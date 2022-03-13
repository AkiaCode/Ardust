import com.fazecast.jSerialComm.*

object Ardust extends App {

  val ports: Array[SerialPort] = SerialPort.getCommPorts
  ports.foreach("PORTS: " + println(_))

  val port: SerialPort = ports(0)
  println("DATA RATE: " + port.getBaudRate)

  var num: Int = 0
  port.openPort()

  try {
    while (port.isOpen) {
      var string: String = num match {
        case 0 => "RED"
        case 1 => "YELLOW"
        case 2 => "GREEN"
        case 3 => "NOTHING"
      }

      port.writeBytes(string.getBytes(), string.getBytes().length)
      println("Sent " + string + " to " + port.toString)
      Thread.sleep(5000)
      if (num < 3) num += 1 else num = 0
    }
  } finally {
     port.writeBytes("NOTHING".getBytes(), "NOTHING".getBytes().length)
     port.closePort()
  }
}