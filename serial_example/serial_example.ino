int dadoLido=0; //variável que receberá os dados da porta serial
int dadoEscrito=0;
 
void setup(){
  Serial.begin(9600);//frequência da porta serial
}
 
void loop(){
  if(Serial.available() > 0){ //verifica se existe comunicação com a porta serial
      dadoLido = Serial.read();//lê os dados da porta serial
      dadoEscrito = dadoLido *2;
      delay(100);
      Serial.write(dadoEscrito);
  }
  
}
