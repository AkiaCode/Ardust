
const int RedLedPin =  13;
const int YellowLedPin =  12;
const int GreenLedPin =  11;


void setup() {
  Serial.begin(9600);
  pinMode(RedLedPin, OUTPUT);
  pinMode(YellowLedPin, OUTPUT);
  pinMode(GreenLedPin, OUTPUT);
}

void loop() {
  if (Serial.available()) {
    String read_value = Serial.readString();
    Serial.println(read_value);
    digitalWrite(RedLedPin, read_value == "RED" ? HIGH : LOW);
    digitalWrite(YellowLedPin, read_value == "YELLOW" ? HIGH : LOW);
    digitalWrite(GreenLedPin, read_value == "GREEN" ? HIGH : LOW);
  }
}
