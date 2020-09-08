function exibirMensagem() {
	var data = new Date();
	alert(data.toString());
}

function validaMatricula() {
	//var mtr = document.querySelectorAll("#j_idt18:matricula");
	/*if (isNaN(mtr.value)) {
		alert('Digite apenas números!');

	} 
	*/
	alert('dafsafa');
	
	
}

function SomenteNumero(e) {
    var tecla; //Armazena a tecka pressionada.
	
    if (e.which) {
        tecla = e.which;
    } else {
        tecla = e.keyCode;
    }

    if ((tecla >= 48 && tecla <= 57) || (e.which == 08)) {
        return true;
    } else {
        return false;
    }
 }


