
### Explicación de la Práctica

La actualización en esta práctica se realiza mediante el nuevo DAO basado en ficheros (ReservaFileDAO), 
que sustituye el almacenamiento en memoria por persistencia en archivos. La información se guarda en la carpeta 
data, dentro del archivo reservas.txt, donde cada línea representa una reserva. Para actualizar, el DAO primero 
lee todo el fichero y reconstruye los objetos en una lista. Después busca la reserva por su identificador y 
la reemplaza en memoria. Una vez modificada la lista, se vuelve a escribir todo el contenido en el fichero usando
writeText(). De esta forma, el archivo siempre refleja el estado actualizado de las reservas. 
Si la reserva no existe, la operación no realiza cambios y devuelve false.


[CE 7.c] ¿Que librería/clases has utilizado para realizar la práctica.? Comenta los métodos mas interesantes.

[He utilizado las librerias principales de kotlin, las LocalDateTime y las kotlin.collections.
file.writeText(contenido), la he utilizado para guaradr las reservas del crud]


    
[CE 7.d] 2.a ¿Que formato le has dado a la información del fichero para guardar y recuperar la información? 

[He utilizado txt]
         2.b ¿Que estrategia has usado para trabajar con los ficheros? (Carpeta en donde se guardan los ficheros, cuando crear los archivos, ....) 

[La estrategia es utilizar la carpeta data, con el archivo único txt y lo creo manualmente.]
https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-indadominguez/blob/c938d29842c06598d193f1c4387dd257dc7d7e98/src/main/kotlin/dao/ReservaFileDAO.kt#L7-L15
         2.c ¿Cómo se gestionan los errores? 

[En el programa uso 3 formas distintas con try catch, requires y controlando archivos inexistentes.]
https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-indadominguez/blob/c938d29842c06598d193f1c4387dd257dc7d7e98/src/main/kotlin/dao/ReservaFileDAO.kt#L12
         Pon ejemplos de código (enlace permanente al código en GitHub).
         
[CE 7.e] 3.a Describe la forma de acceso para leer información 

[La lectura de información la hago con el readLines leyendo las líneas del fichero y se hacen los objetos de vuelo y viaje]
         3.b Describe la forma de acceso para escribir información 

[El acceso se hace con writeText y se convierte la lista en texto.]
         3.c Describe la forma de acceso para actualizar información. 

[La actualización la cargo en todo el fichero se modifica en memoria y se sobreescribe el fichero.]
https://github.com/IES-Rafael-Alberti/2526-u6-6-6-travelbooker-indadominguez/blob/c938d29842c06598d193f1c4387dd257dc7d7e98/src/main/kotlin/dao/ReservaFileDAO.kt#L81-L87
         Pon ejemplos de código (enlace permanente al código en GitHub).
