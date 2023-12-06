//NAV-BAR
const conferencia = document.getElementById("conferenciaNav");
const oradores = document.getElementById("oradoresNav");
const tickets = document.getElementById("tickets");

oradores.addEventListener("click",()=>cambiarClase(oradores));
conferencia.addEventListener("click",()=>cambiarClase(conferencia));
tickets.addEventListener("click",()=>cambiarClase(tickets));


function cambiarClase(elemento){
    if(elemento!=tickets){
        elemento.classList.add('seleccionado');
    }

    if(elemento!=conferencia){
        conferencia.classList.remove('seleccionado');
    }
    if(elemento!=oradores){
        oradores.classList.remove('seleccionado');
    }


}