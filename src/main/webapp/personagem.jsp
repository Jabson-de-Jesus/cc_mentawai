<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>cc_mentawai</title>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.1.0/pure-min.css">
</head>
<body style="padding: 10px 10px 10px 10px">

    <form class="pure-form" method="post" action="PersonagemAction.salvaOuAtualiza.mtw">
		<fieldset>
			<legend>Personagem</legend>
			<input type="hidden" name="personagemId" value="${personagem.id}">
			
			<input type="text" name="nome" placeholder="Nome do personagem" value="${personagem.nome}"> 
			<button type="submit" class="pure-button notice">Salvar</button>
		</fieldset>
    </form>


    <table class="pure-table pure-table-bordered" style="width: 500px;">
    <thead>
        <tr>
            <th>#</th>
            <th>Nome</th>
            <th>[]</th>
            <th>X</th>
        </tr>
    </thead>

    <tbody>
        <mtw:list value="personagens">
          <mtw:loop var="p">
          <tr>
              <td>${p.id}</td>
              <td>${p.nome}</td>
              <td><a href="PersonagemAction.prepareUpdate.mtw?id=${p.id}">[]</a></td>
              <td><a href="PersonagemAction.remove.mtw?id=${p.id}">X</a></td>
          </tr>
		</mtw:loop>
		</mtw:list>
    </tbody>
	</table>
    

</body>
</html>
