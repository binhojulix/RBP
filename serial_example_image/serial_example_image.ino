   
 #define tamanho 688
 byte buf[tamanho];
    
void setup() {
 Serial.begin(9600);     // opens serial port, sets data rate to 9600 bps
}

void loop() {
  
   
    
    if (Serial.available() > 0) {

          Serial.readBytes(buf, tamanho);
          delay(100);
          Serial.write(buf, tamanho);     
       }
}


