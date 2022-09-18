function renderForm(){
    let form = $('<form id="form" method="post" action="#">')
    let title = $('<h2>Cadastro de frases</h2>')
    let div1 = $('<div class="input"><input id="title" type="text" required maxlength="20"><label>Título</label></div>')
    let div2 = $('<div class="input"><input id="frase" type="text" required maxlength="100"><label>Frase</label></div>')
    let button = $('<button type="submit" onclick="armazenar()" id="btn">Enviar</button></form>')
    
    $(title).appendTo(form);
    $(div1).appendTo(form)
    $(div2).appendTo(form)
    $(button).appendTo(form)

    $('#content').html(form)
}

function reload(){
    let div = $('<div></div>')
    $('#content').html(div)
}

function renderCard(){       
    let container = $('<div class="Container_card">')
    let card = $('<div class="card_vanilla">')
    let content = $('<div class="content_card"><h2 id="card_id">01</h2><h3 id="card_title">Verso 1</h3><p id="card_phrase">Lembro com muita saudade daquele bailinho.</p></div>')

    $(card).appendTo(container);
    $(content).appendTo(card);

    $('#content').html(container)
}