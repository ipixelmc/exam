<script>

</script>

<div>
    <div id="dlgUpModalId" class="modal fade">
        <div class="modal-dialog" style="width:800px">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="alert alert-info ">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="element-center"><i class="glyphicon glyphicon-user "></i>&nbsp;&nbsp;Persona
                        </h4>
                    </div>
                </div>
                <div class="modal-body">
                    <div>
                        <form  class="form-horizontal"
                             >
                            <br/>
                            <div class="row">
                                <div class="col-xs-10 col-xs-offset-1">
                                    <div class="col-xs-2">G&eacute;nero:</div>
                                    <div class="col-xs-10">
                                        Hombre: <input type="radio" name="gender" ng-model="p.gender" value="1"> &nbsp;
                                        Mujer: <input type="radio" name="gender" ng-model="p.gender" value="0"> &nbsp;
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="col-xs-10 col-xs-offset-1">
                                <div class="col-xs-6">
                                    Nombre:<br/>
                                    <input type="text" ng-model="p.name"/>
                                </div>
                                <div class="col-xs-6">
                                    Edad:<br/>
                                    <input type="text" ng-model="p.age"/>
                                </div></div>
                            </div>
                            <br/>
                            <div class="row">
                                <div  class="col-xs-10 col-xs-offset-1">
                                    <div class="col-xs-12">
                                    Direcci&oacute;n:<br/>
                                    <textarea style="width: 100%" ng-model="p.address"></textarea>
                                </div></div>
                            </div>
                            <br/>
                            <div class="row" ng-show="p.gender==1">
                                <div class="col-xs-10 col-xs-offset-1">
                                    <div class="col-xs-6">
                                        N&uacute;mero de identificaci&oacute;n:<br/>
                                        <input type="text" ng-model="p.idIdentification"/>
                                    </div>
                                    <div class="col-xs-6">
                                        Profesi&oacute;n:<br/>
                                        <input type="text" ng-model="p.profession"/>
                                    </div></div>
                            </div>
                            <div class="row" ng-show="p.gender==0">
                                <div class="col-xs-10 col-xs-offset-1">
                                    <div class="col-xs-6">
                                        Escuela:<br/>
                                        <input type="text" ng-model="p.school"/>
                                    </div>
                                    <div class="col-xs-6">
                                        Tel&eacute;fono:<br/>
                                        <input type="text" ng-model="p.phone"/>
                                    </div></div>
                            </div>
                        </form>
                    </div>
                    <br/>
                    <div ng-show="message" class="alert alert-danger element-center">
                        <p ng-model="message"></p>
                    </div>
                </div>
                <div class="modal-footer">
                    <span class="btn btn-default btn-sm" ng-click="cancel('dlgUpModalId')">
                        Cancelar
                    </span>
                    <span class="btn btn-default btn-primary btn-sm" ng-click="upsertItem()">
                    Guardar
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>

