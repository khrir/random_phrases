function renderForm() {
    let form = $('<form id="form" method="post" action="/">')
    let title = $('<h2>Cadastro de frases</h2>')
    let div1 = $('<div class="input"><input id="title" name="title" type="text" required maxlength="20"><label>Título</label></div>')
    let div2 = $('<div class="input"><input id="phrase" name="phrase" type="text" required maxlength="100"><label>Frase</label></div>')
    let button = $('<button type="submit" onclick="sendPhrase(event)" id="submit-btn">Enviar</button></form>')

    $(title).appendTo(form);
    $(div1).appendTo(form)
    $(div2).appendTo(form)
    $(button).appendTo(form)

    $('#content').html(form)
}

function reload() {
    let div = $('<div></div>')
    $('#content').html(div)
}

async function renderCard() {
    let id = gerarRandomNumber()
    await fetch("http://localhost:8080/phrase/" + id, {
        method: 'get',
    }).then(function (result) {
        return result.json()
    }).then(function (data) {
        console.log(data)
        let container = $('<div class="Container_card">')
        let card = $('<div class="card_vanilla">')
        let content = $('<div class="content_card"><h2 id="card_id">0' + data.id + '</h2><h3 id="card_title">' + data.title + '</h3><p id="card_phrase">' + data.phrase + '</p></div>')
        $(card).appendTo(container);
        $(content).appendTo(card);

        $('#content').html(container)
    })
}

function gerarRandomNumber() {
    let num = parseInt((Math.random() * 7))
    if (num == 0) {
        num = gerarRandomNumber()
    }
    return num
}

function sendPhrase(e){
    e.preventDefault()
    let title = document.getElementById('title').value;
    let phrase = document.getElementById('phrase').value;
    // let phraseModel = {title: title, phrase: phrase}

    axios.post('http://localhost:8080/', {title, phrase})
        .then(function (response) {
            console.log(response)
            if (response.status === 200) {
                // alert('O pai tá on');
                window.location.assign('/');
            }
        })
        .catch(function (error) {
            console.log(error);
            alert('Ih, sujou');
        })
}