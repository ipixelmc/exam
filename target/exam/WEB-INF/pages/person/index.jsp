<!doctype html>
<html ng-app="examApp">

<head>
    <jsp:include page="../shared/layout.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/assets/scripts/personCtrl.js"></script>
    <script>

    </script>
</head>
<body>
<div ng-controller="PersonController">
    <br/>
   <div class="row text-center label-primary title">
       <br/>
        <span class="glyphicon glyphicon-user"></span>
       <label>Personas</label>
   </div>
    <br/>

    <div class="row">
        <div class="col-xs-5 col-xs-offset-1">
            Filtrar por nombre:
            <input style="width: 50% !important;" type="text" ng-model="name" ng-change="findPersonName()"/>&nbsp;
             </div>
        <div class="col-xs-1 col-xs-offset-3">
            <a ng-click="showUpsert();" class="btn btn-primary" role="button">Agregar persona</a>
        </div>
    </div>
    <br/>
    <div class="row" ng-init='list = ${list}'>

        <div class="col-xs-10 col-xs-offset-1">

            <div class="panel panel-default">

                <table class="table">
                   <tr>
                       <th>Nombre</th>
                       <th>Edad</th>
                       <th>Direcci&oacute;n</th>
                       <th>Informaci&oacute;n adicional</th>
                       <th>Acciones</th><input type="hidden" id="idPerson"/>
                   </tr>
                    <tr ng-repeat="p in list">
                        <td>{{p.name}}</td>
                        <td>{{p.age}}</td>
                        <td>{{p.address}}</td>
                        <td ng-show="p.gender == 0">
                            <ul>
                                <li>Escuela - {{p.school}}</li>
                                <li>Tel&eacute;fono - {{p.phone}}</li>
                            </ul>
                        </td>
                        <td ng-show="p.gender == 1">
                            <ul>
                                <li>Identificaci&oacute;n - {{p.idIdentification}}</li>
                                <li>Profesi&oacute;n - {{p.profession}}</li>
                            </ul>
                        </td>
                        <td><span class="glyphicon glyphicon-pencil c" ng-click="showUpsert(p.id);"></span> &nbsp;
                        <span class="glyphicon glyphicon-trash c" ng-click="showDelete(p.id)"></span></td>
                    </tr>
                </table>
            </div>

        </div>
    </div>

    <div id="dlgDeleteId" class="modal fade">
        <div class="modal-dialog" style="width:40%">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="alert alert-danger ">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="element-center"><i class="glyphicon glyphicon-user "></i>&nbsp;&nbsp;Eliminar persona
                        </h4>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="col-xs-10 col-xs-offset-1">
                       &iquest;Est&aacute; seguro que desea eliminar el resigro?
                    </div>
                    <br/>
                </div>
                <div class="modal-footer">
                    <span class="btn btn-default btn-sm" ng-click="cancel('dlgDeleteId')">
                        Cancelar
                    </span>
                    <span class="btn btn-default btn-danger btn-sm" ng-click="deleteItem();">
                    Acpetar
                    </span>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="upsert.jsp"></jsp:include>
</div>
</body>
</html>