// Use H2Driver to connect to an H2 database

import slick.driver.MySQLDriver.simple._


object SlickExample {

  // Product table definition
  class Products(tag: Tag) extends Table[(Long, String, String)](tag, "products") {
    def ean = column[Long]("ean", O.PrimaryKey)
    def name = column[String]("name")
    def description = column[String]("description")
    def * = (ean, name, description)
  }
  val products = TableQuery[Products]

  def main(args: Array[String]) {

    // Query object.
    val p = for {
      product <- products.sortBy(product => product.name.asc)
    } yield (product)

    // Database session

    // Create a connection (called a "session") to an in-memory H2 database
    Database.forURL("jdbc:mysql://192.168.59.103:3306/slick", driver="com.mysql.jdbc.Driver", user="slick", password="slick").withSession
    { implicit session =>
      val productList = products.list
      println(productList mkString "\n")
    }
  }
}