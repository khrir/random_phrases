function renderForm() {
    let form = $('<form id="form" method="post" action="/create">')
    let title = $('<h2>Cadastro de frases</h2>')
    let div1 = $('<div class="input"><input id="title" name="title" type="text" required maxlength="20"><label>Título</label></div>')
    let div2 = $('<div class="input"><input id="phrase" name="phrase" type="text" required maxlength="100"><label>Frase</label></div>')
    let button = $('<button type="submit" onclick="createPhrase(event)" id="create-btn">Enviar</button></form>')

    $(title).appendTo(form);
    $(div1).appendTo(form)
    $(div2).appendTo(form)
    $(button).appendTo(form)

    $('#content').html(form)
}

function renderUpdateForm() {
    let form = $('<form id="form" method="post" action="/update">')
    let title = $('<h2>Atualizar frase</h2>')
    let div1 = $('<div class="input"><input id="id" name="id" type="number" required maxlength="2"><label>ID</label></div>')
    let div2 = $('<div class="input"><input id="title" name="title" type="text" required maxlength="20"><label>Novo título</label></div>')
    let div3 = $('<div class="input"><input id="phrase" name="phrase" type="text" required maxlength="100"><label>Nova frase</label></div>')
    let button = $('<button type="submit" onclick="updatePhrase(event)" id="update-btn">Enviar</button></form>')

    $(title).appendTo(form);
    $(div1).appendTo(form)
    $(div2).appendTo(form)
    $(div3).appendTo(form)
    $(button).appendTo(form)

    $('#content').html(form)

}

function reload() {
    let div = $('<div></div>')
    $('#content').html(div)
}

function renderDeleteForm() {
    let form = $('<form id="form" method="post" action="/delete">')
    let title = $('<h2>Cadastro de frases</h2>')
    let div1 = $('<div class="input"><input id="id" name="id" type="number" required maxlength="2"><label>ID</label></div>')
    let button = $('<button type="submit" onclick="deletePhrase(event)" id="del-btn">Enviar</button></form>')

    $(title).appendTo(form);
    $(div1).appendTo(form)
    $(button).appendTo(form)

    $('#content').html(form)
}

// CRUD
function gerarRandomNumber(length) {
    let num = parseInt((Math.random()) * length)
    return num
}

function createPhrase(e) {
    e.preventDefault()
    let title = document.getElementById('title').value;
    let phrase = document.getElementById('phrase').value;

    axios.post('http://localhost:8080/create', { title, phrase })
        .then(function (response) {
            if (response.status === 200) {
                window.location.assign('/');
            }
        })
        .catch(function (error) {
            console.log(error);
            alert('Ih, sujou');
        }
    )
}

async function renderCard() {
    await fetch("http://localhost:8080/phrase/all", {
        method: 'get',
    }).then(function (result) {
        return result.json()
    }).then(function (data) {
        let index = gerarRandomNumber(data.length)
        let container = $('<div class="Container_card">')
        let card = $('<div class="card_vanilla">')
        let content = $('<div class="content_card"><h2 id="card_id">0' + data[index].id + '</h2><h3 id="card_title">' + data[index].title + '</h3><p id="card_phrase">' + data[index].phrase + '</p></div>')
        $(card).appendTo(container);
        $(content).appendTo(card);

        $('#content').html(container)
    })
}

function updatePhrase(e) {
    e.preventDefault();

    let id = document.getElementById('id').value;
    let title = document.getElementById('title').value;
    let phrase = document.getElementById('phrase').value;

    axios.post('http://localhost:8080/update', {id, title, phrase})
        .then(function (response) {
            if (response.status === 200) {
                window.location.assign('/')
            }
        })
        .catch(function (error) {
            console.log(error)
            alert('Ih, sujou')
        }
    )
}

function deletePhrase(e){
    e.preventDefault()

    let id = document.getElementById('id').value;
    axios.post('http://localhost:8080/delete', id)
        .then(function (response) {
            if(response.status === 200){
                window.location.assign('/')
            }
        }).catch(function(error) {
            console.log(error)
            alert('Ih, sujou')
        })
}