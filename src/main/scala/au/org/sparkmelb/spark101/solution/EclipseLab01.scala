package scala.au.org.sparkmelb.spark101.solution

// Import libraries
import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * @author timothy.findlay
 */
object EclipseLab01 {

  def main(args: Array[String]) {

    // Setup Spark Configuration
    val sparkConf = new SparkConf().setAppName("EclipseLab01").setMaster("local[1]")
  
    // Define Spark Context
    val sparkContext = new SparkContext( sparkConf )
    
    // Setup SQL Context to get Dataframe
    val sqlContext = new SQLContext( sparkContext )  
  
    // Define Filename, store in a static variable fileName
    val fileName="C:\\SparkMelbourne\\spark-1.3.1-bin-hadoop2.6\\data\\people.json"

    // Perform the read
    var newRows = sqlContext.jsonFile( fileName )
     
    // Display results
    println( "Read " +  newRows.count() + " row(s) from: " + fileName)  

  }

}