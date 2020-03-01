# TiendaFootFisi-backend  
Back-end del sistema de ventas web de la tienda Foot Fisi  

Publicado en Heroku:https://tienda-foot-fisi-backend.herokuapp.com/  

REST API:  

Categoría:  
Listar marcas (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/categoria/listar/marca  
Listar generos por marca (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/categoria/listar/genero/{sMarca}  
Listar tipo por genero y marca (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/categoria/listar/tipo/{sMarca}/{sGenero}  

Cliente:  
Listar clientes (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/cliente/listar  
Buscar cliente (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/cliente/buscar/{sIdTipoDocumento}/{sNumeroDocumento}  
Registrar cliente (POST): https://tienda-foot-fisi-backend.herokuapp.com/api/api/cliente/registrar  

Login:  
Buscar usuario - cliente (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/login/usuario/{sIdUsuario}/{sContrasenia}  

Pedido:  
Registrar pedido (POST): https://tienda-foot-fisi-backend.herokuapp.com/api/pedido/registrar  

Producto:  
Listar productos (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/producto/listar  
Listar productos por categoría (POST): https://tienda-foot-fisi-backend.herokuapp.com/api/producto/listar/filtro  
Registrar producto (POST): https://tienda-foot-fisi-backend.herokuapp.com/api/producto/registrar  

Talla:  
Listar tallas (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/talla/listar  

Tipo de documentos:  
Listar tipos de documentos (GET): https://tienda-foot-fisi-backend.herokuapp.com/api/tipodocumento/listar  



Consideraciones:  

Esta aplicación esta empaquetada como un war por lo tanto se debe leer la siguiente documentación:  
https://devcenter.heroku.com/articles/deploying-java-applications-with-the-heroku-maven-plugin  

https://stackoverflow.com/questions/53050441/error-your-buildpacks-do-not-contain-the-heroku-jvm-buildpackadd-heroku-jvm-to

Herramientas instaladas:  

*Maven 3. (Link: https://www.youtube.com/watch?v=ExOl1qkYGiI)  
*Java 1.8.  
*Heroku Cli. (https://devcenter.heroku.com/articles/heroku-cli)  
