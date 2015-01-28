angular.module('examApp', [])

    .controller('PersonController', ['$scope', function($scope,$rootScope) {
        $scope.list={};
        $scope.message="";
        $scope.id;
        $scope.path=$("#contextURL").val();

        $scope.showUpsert = function(id){
            $scope.message="";

            if(id!=undefined && id != ''){
                $scope.findPerson(id);
                $scope.id = id;
            }else{
                $scope.id =undefined;
            }
            $("#dlgUpModalId").show();
            $('#dlgUpModalId').modal('show')
        };

        $scope.findPersonName= function(id){
            if($scope.name==undefined){
                $scope.name="";
            }
            $.ajax( {
                url:$scope.path+"findPersonName.json?name="+$scope.name,
                async:false
            } )
                .done(function(data) {
                    try{

                        $scope.list = data;
                    }catch(e) {
                        $scope.list ={};
                    }
                })
                .fail(function() {
                    $scope.message="Ha ocurrido un error al actualizar la lista";

                })
            ;
        }
        $scope.showDelete = function(id){
            $("#dlgDeleteId").show();
            $('#dlgDeleteId').modal('show')
            $scope.id=id
        };
        $scope.cancel = function(id){
            $scope.p={};
            $("#"+id).hide();
        };

        $scope.loadList = function(){
            $.ajax( {
                url:$scope.path+"loadList.json",
                async :false
            } )
                .done(function(data) {
                    try{

                        $scope.list = data;
                    }catch(e) {
                        $scope.list ={};
                    }
                })
                .fail(function() {
                   $scope.message="Ha ocurrido un error al actualizar la lista";
                    $scope.WaitFor =false;
                })
                ;

        };
        $scope.findPerson= function(id){
            $.ajax( $scope.path+"findPerson.json?id="+id )
                .done(function(data) {
                    $scope.p = data;
                    $scope.$apply();

                })
                .fail(function() {
                    $scope.message="Ha ocurrido un error al actualizar la lista";

                })
            ;
        }
        $scope.upsertItem = function(){
            $scope.WaitFor =true;
            var p = $scope.p;
            var params ="";
            if($scope.id!= undefined){
               params =  "id="+ p.id+"&";
            }
             params += "name="+ p.name+"&address="+ p.address+"&age="+ p.age+"&idIdentification="+ p.idIdentification+
                 "&profession="+ p.profession +"&school="+ p.school +"&phone="+ p.phone+"&gender="+ p.gender;
            $.ajax({
              url: $scope.path+"upsert.json?"+params,
                async: false
            })
                .done($scope.done())
                .fail($scope.fail());

        }

        $scope.deleteItem = function() {
            $scope.WaitFor = true;

            $.ajax({
                url :$scope.path+"delete.json?id="+$scope.id,
                async : false
            })
                .done($scope.done())
                .fail($scope.fail());

        };

        $scope.done = function(){

            $scope.loadList();
            $scope.p ={};
            $("#dlgUpModalId").hide();
            $("#dlgDeleteId").hide();
            $scope.id = undefined;
        };

        $scope.fail = function(){
            $scope.message="Ha ocurrido un error al eliminar";
            $scope.WaitFor =false;
        };
    }]);