var app = angular.module("myShoppingList", []);
app.controller("myCtrl", function($scope) {
  $scope.person = true;
  $scope.anyperson = true;
  $scope.name = "";
  $scope.products = [{item:"Milk",q:5}, {item:"Bread",q:5}, {item:"Cheese",q:5}];
  $scope.cart = [];
  $scope.errortext = "";

  $scope.admin = function(){
    if (!angular.equals($scope.name, ""))
    {
      $scope.anyperson = false;
      if (angular.equals($scope.name, "admin"))
          $scope.person = false;
      else
        $scope.person = true;
    }
    else
        $scope.anyperson = true;
    $scope.errortext = "";
  }

  $scope.addItem = function () {
    if (!$scope.addI && !$scope.addQ)
      return;
    newObject = {item:$scope.addI ,q:$scope.addQ};
    for (var i = 0; i < $scope.products.length; i++)
    {
      if (angular.equals($scope.products[i].item,$scope.addI))
      {
          $scope.products[i].q = +$scope.products[i].q + +$scope.addQ;
          return;
      }
    }
    $scope.products.push(newObject);
  }

  $scope.removeItem = function () {
    if (!$scope.remI && !$scope.remQ)
      return;
    $scope.products[$scope.remI] = $scope.remQ;
    for (var i = 0; i < $scope.products.length; i++)
    {
      if (angular.equals($scope.products[i].item,$scope.remI))
      {
          if(+$scope.products[i].q < +$scope.remQ)
              $scope.errortext = "Insufficient Item";
          else
              $scope.products[i].q = +$scope.products[i].q - +$scope.remQ;
          return;
      }
    }
    $scope.errortext = "Invalid Item Details";
  }

  $scope.addCart = function () {
    var pr=0,cr=0;
    if (!$scope.addCartI && !$scope.addCartQ)
      return;
    newObject = {item:$scope.addCartI ,q:$scope.addCartQ};

    for (pr = 0; pr < $scope.products.length && !angular.equals($scope.products[pr].item,$scope.addCartI); pr++);
    for (cr = 0; cr < $scope.cart.length && !angular.equals($scope.cart[cr].item,$scope.addCartI); cr++);


    if (pr==$scope.products.length)
        $scope.errortext="Invalid Item";
    else if (cr==$scope.cart.length){
        $scope.products[pr].q = +$scope.products[pr].q - +$scope.addCartQ;
        $scope.cart.push(newObject);
    }
    else if (+$scope.addCartQ > +$scope.products[pr].q )
        $scope.errortext="Insufficient Item";
    else{
      $scope.products[pr].q = +$scope.products[pr].q - +$scope.addCartQ;
      $scope.cart[cr].q = +$scope.cart[cr].q + +$scope.addCartQ;
    }
  }

  $scope.removeCart = function (x) {
    $scope.errortext="";
    var pr=0;
    for (pr = 0; pr < $scope.products.length && !angular.equals($scope.products[pr].item,$scope.cart[x].item); pr++);
    $scope.products[pr].q = +$scope.products[pr].q + +$scope.cart[x].q;
    $scope.cart.splice(x, 1);
  }
});
