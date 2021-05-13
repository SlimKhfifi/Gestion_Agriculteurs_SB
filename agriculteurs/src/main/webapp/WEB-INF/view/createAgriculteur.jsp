<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
layout:decorator="template">
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<head>
<meta charset="utf-8">
<title>Ajouter Agriculteur</title>
</head>
<body>
<div class="container mt-5" >
<div class="card-body">
<form action="saveAgriculteur" method="post">
<div class="form-group">
<label class="control-label">Nom Agriculteur :</label>
<input type="text" name="nomAgriculteur" class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">Salaire Agriculteur :</label>
<input type="text" name="salaireAgriculteur" class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">date embauche :</label>
<input type="date" name="date" class="form-control"/>
</div>
<div>
<button type="submit" class="btn btn-primary">Ajouter</button>
</div>
</form>
</div>
${msg}
<br/>
<br/>
<a href="ListeAgriculteurs">Liste Agriculteurs</a>
</div>
</body>
</html>