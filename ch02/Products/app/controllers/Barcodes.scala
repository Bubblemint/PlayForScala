package controllers

/**
 * Created with IntelliJ IDEA.
 * User: Yoonsoo Lee(Bubblemint@sk.com)
 * Date: 15. 7. 15.
 */
import play.api.mvc.{Action, Controller}


object Barcodes extends Controller {

  val ImageResolution = 144

  def barcode(ean: Long) = Action {

    val MimeType = "image/png"
    try {
      val imageData = ean13BarCode(ean, MimeType)
      Ok(imageData).as(MimeType)
    }
    catch {
      case e: IllegalArgumentException =>
        BadRequest("Couldn’t generate bar code. Error: " + e.getMessage)
    }
  }

  def ean13BarCode(ean: Long, mimeType: String): Array[Byte] = {

    import java.awt.image.BufferedImage
    import java.io.ByteArrayOutputStream

    import org.krysalis.barcode4j.impl.upcean.EAN13Bean
    import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider

    var output: ByteArrayOutputStream = new ByteArrayOutputStream
    var canvas: BitmapCanvasProvider =
      new BitmapCanvasProvider(output, mimeType, ImageResolution,
        BufferedImage.TYPE_BYTE_BINARY, false, 0)

    val barCode = new EAN13Bean()
    barCode.generateBarcode(canvas, String valueOf ean)
    canvas.finish

    output.toByteArray
  }
}