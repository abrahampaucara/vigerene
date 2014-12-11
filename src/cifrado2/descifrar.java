package cifrado2;

public class descifrar {


    char[] mensajito;
    char[] mensajote;
    char[] clave;
    
    char[] resultado;
    char matrix[][];
    

    public  descifrar(String msj,String clave)
    {	
        this.mensajito = msj.toCharArray();
        this.mensajote = mensajito;
        char[] claveTemp = clave.toCharArray();
		this.clave = new char[mensajito.length];
		int cont =0;
		for(int i=0;i<mensajito.length;i++)//For mete la clave multiples veces en 1 arreglo
		{
			this.clave[i]=claveTemp[cont];
			cont++;
			if(cont==claveTemp.length)
				cont=0;
		}
        
        this.matrix = generarMatrizABC();
        System.out.println(matrix[1][1]);
        System.out.println(this.mensajito);
        
        descifrar2();
    }
    
    public void descifrar2() //Genera cifrado
	{
                this.mensajito = mensajote;
                char [] descifrado = new char [mensajito.length];
		//System.out.println(mensajito.length);
		int i;
		int j;
                
                
		for(int cont=0;cont<mensajito.length;cont++)
		{
			//Primero calculamos el indice de cada matriz "i" y "j"
			//el indice "i" correspondera al arreglo del mensaje
			//el indice "j" correspondera al arreglo de la clave 
			//luego ejecutaremos el calculo para cifrar utilizando "i" y "j" como cordenadas de la matriz
			//i=(int)this.mensajito[cont]-97; //restamos 97 para pasar de codigo ascii a un numero entero
			i=this.mensajito[cont];
                        j=(int)this.clave[cont]-97;  
                        
                        //System.out.println(matriz[2][1]);
                        for(int k=0;k<25;k++)
                        {
                            //System.out.println(matriz[j][k]); 
                            if(matrix[j][k]==i)
                            {
                               
                               //System.out.println(matriz[0][k]);
                               descifrado[cont]=this.matrix[0][k];
                            }
                        }

		}

		this.resultado = descifrado;
		//for(int n = 0;n<26;n++)
		//	System.out.println(this.matriz[0][n]);

		//System.out.println(this.mensaje);
		//System.out.println(this.clave);
		System.out.println(descifrado);
	}

    public String getMensajeDes()
	{
		String result="";
		for(int i=0;i<resultado.length;++i)
			result=result+this.resultado[i];
		return result;
	} 
    private char[][] generarMatrizABC()
    {
            int contador;
            char abcTemp[] = this.generarAbecedario();
            char abc[] = new char[abcTemp.length*2];
            for(int c=0;c<26;c++) {
                    abc[c]=abcTemp[c];
                    abc[c+26]=abcTemp[c];
            }
            char[][] matriz = new char[26][26];
            for(int i=0;i<26;i++)
            {
                    contador=0;
                    for(int j=0;j<26;j++)
                    {
                            matriz[i][j]=abc[contador+i];
                            contador++;
                    }
            }
            return matriz;
    }

    private char[] generarAbecedario()
    {
            char[] abc = new char[26];

            for(int i= 97; i<= 122;i++)
            {
                    abc[i-97]=(char)i;

            }
            return abc;
    }

    
}
