#include "extra.h"

void validar_cantidad_productos (int &tope){
    while (tope <= PRODUCTO_MINIMO || tope > MAXIMO_PRODUCTO ){
        cout<<"Si desea cargar productos al chango estos deben ser mayores a 50"<<endl; 
        cin>>tope;
    }
}

void pedir_cantidad_productos (int &tope){
    cout << "¿Cuantos productos desea ingresar?"<<endl; cin>>tope;
    validar_cantidad_productos (tope);
}

int contador_ofertas (Producto Vector[MAXIMO_PRODUCTO], int tope, int cantidad_ofertas){
    for(int i = 0; i < tope; i++){
        if (Vector[i].oferta)
            cantidad_ofertas ++;
    }
    return cantidad_ofertas;
}

void pedir_datos (string &nombre_producto, float &precio, unsigned long &codigo, char &respusta){
    cout <<" Ingrese el nombre del producto." <<endl; cin >> nombre_producto; //Tomo como inicio a la posicion 1 del chango.
    cout  << " Ingrese el precio del producto."<<endl; cin >> precio; 
    cout  << " Ingrese el codigo del producto."<<endl; cin >> codigo; // El codigo es unico.
    cout  <<" ¿El producto esta en oferta? Y / N"<<endl; cin >> respusta; 
}

void cargar_productos_gondola (Producto Gondola [MAXIMO_PRODUCTO], int tope_gondola){
    char respusta;
    for (int i = 0; i < tope_gondola; i++){
        cout <<"Producto -> " << i+INICIO_I << endl;
        pedir_datos(Gondola[i].nombre, Gondola[i].precio, Gondola[i].codigo, respusta); 
        Gondola[i].oferta = respuesta_yes_no(respusta); 
    }
}

bool respuesta_yes_no (char &respusta){
    bool es_positiva = false;
    if (respusta == YES)
        es_positiva = true;
    return es_positiva;
}

bool es_nombre (string respuesta_usuario){
    bool es_nombre = false;
    if(respuesta_usuario.compare(NOMBRE_PRODUCTO) == 0)
        es_nombre = true;
    return es_nombre;    
}

void ingreso_nombre_codigo (string &nombre_buscado, unsigned long &codigo_buscado, string &respuesta_usuario){
    if(es_nombre(respuesta_usuario)){
        cout <<"Ingrese el nombre del producto."<<endl; cin>> nombre_buscado;    
    }    
    else{
        cout << "Ingrese el codigo del producto."<<endl; cin>> codigo_buscado;   
    }    
}

void  pedir_busqueda_producto(string &nombre_buscado, unsigned long &codigo_buscado, Producto Gondola[MAXIMO_PRODUCTO], int tope_gondola, int posicion){
    char respusta_yes_no;
    string respuesta_usuario;
    cout << "¿Desea buscar un producto por nombre o codigo Y/N ?"<<endl; cin>> respusta_yes_no;
    if (respuesta_yes_no(respusta_yes_no)){
        cout << "Si desea buscar por nombre escriba 'nombre' y si desea por codigo escriba 'codigo ' "<<endl; cin >> respuesta_usuario;
        ingreso_nombre_codigo(nombre_buscado, codigo_buscado, respuesta_usuario);
    }
}

void buscar_producto_gondola(Producto Gondola[MAXIMO_PRODUCTO], int tope_gondola, string &nombre_buscado, unsigned long &codigo_buscado){
    for (int i = 0 ; i < tope_gondola; i++){
        if (Gondola[i].nombre == nombre_buscado)
            cout << "El producto buscado esta en la posicion " << i+INICIO_I <<endl; //Suponiendo que la gondola comienza a llenarse desde la posicion 1.
        if (Gondola[i].codigo == codigo_buscado)
            cout << "El producto buscado esta en la posicion " << i+INICIO_I <<endl;
    }
}

void pedir_agregar_producto (Producto Chango [MAXIMO_PRODUCTO], Producto Gondola[MAXIMO_PRODUCTO], int posicion,  int &tope_chango, int &productos_agregados){
    char respusta;
    cout << "¿Desea agregar algun producto Y/N?"<<endl; cin>> respusta;
    if (respuesta_yes_no(respusta)){
        cout << "De la posicion del producto en gondola el cual quiere ingresar al changos"<<endl; cin >>posicion;
        tope_chango++;
        Chango[tope_chango-1] = Gondola[posicion-1];
    }
   
}

void pedir_posicion(int &posicion){
    cout <<"Da la  posicion del producto que desea eliminar: "<<endl; cin>> posicion;
}

void eliminar_elemento(Producto Gondola[MAXIMO_PRODUCTO], int &tope_gondola, int &productos_eliminados, int &posicion_eliminado){
    for (int i = 0; i < tope_gondola; i++)
            if (i+1 == posicion_eliminado)
                Gondola[i] = Gondola[i+1];
            tope_gondola--;
}

void quitar_producto(Producto Gondola[MAXIMO_PRODUCTO], int &tope_gondola, int &productos_eliminados){
    int posicion_eliminado; char respusta;
    cout <<"¿Desea eliminar un producto Y/N?"<<endl; cin>>respusta;
    if(respuesta_yes_no(respusta)){
        pedir_posicion (posicion_eliminado);
        eliminar_elemento(Gondola, tope_gondola, productos_eliminados, posicion_eliminado);
    }
}

void pedir_cambio_codigo(int &posicion){
    char respusta; 
    cout << "¿Desea modificar el codigo de algun producto?"<<endl; cin>> respusta;
}

void modificar_codigo(Producto Gondola[MAXIMO_PRODUCTO],  unsigned long &codigo_modificado){
    int posicion; char respusta;
    cout << "¿Desea modificar el codigo de algun producto? Y/N"<<endl; cin>> respusta;
    if (respuesta_yes_no (respusta)){
        cout << "¿Cual es la posicion del producto el cual desea modificar?"<<endl; cin >> posicion;
        cout << "Ingrese el nuevo codigo"<<endl; cin>>codigo_modificado;
        Gondola[posicion-1].codigo = codigo_modificado;
    }
}

void mostrar_vector (Producto Vector[MAXIMO_PRODUCTO], int tope){
    for (int i = 0; i < tope ; i++)
        cout <<"Producto " << i + INICIO_I << " -Nombre: "<<Vector[i].nombre<< " -Codigo: "<< Vector[i].codigo << " Precio: "<< Vector[i].precio << endl;
}


void cargar_chango (Producto Chango[MAXIMO_PRODUCTO], int tope_chango, Producto Gondola[MAXIMO_PRODUCTO], int &posicion){
    for (int i = 0; i <tope_chango; i++){
        cout << "De la posicion del producto de la gondola el cual quiere ingresar al changos"<<endl; cin >>posicion;
        Chango[i] = Gondola[posicion-1];    
    }    
}

float calcular_ahorro(Producto Chango[MAXIMO_PRODUCTO], int tope_chango, float &ahorro){
    for (int i = 0; i <= tope_chango; i ++)
        if (Chango[i].oferta)
            ahorro = ahorro + (Chango[i].precio*DESCUENTO);
    return ahorro;
}