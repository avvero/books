angular.module("flow", [
    'ngRoute',
    'ui.router'
])
// configure our routes
angular.module("flow").config(function ($routeProvider, $stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/book")

    $stateProvider
        .state('books', {
            url: "/book",
            views: {
                "single": {
                    templateUrl: 'view/books.html',
                    controller: booksController,
                    resolve: booksController.resolve
                }
            }
        })
        .state('book', {
            url: "/book/:id",
            views: {
                "single": {
                    templateUrl: 'view/book.html',
                    controller: bookController,
                    resolve: bookController.resolve
                }
            }
        })

})

angular.module("flow").run(function ($rootScope) {

})

angular.module("flow").controller('mainController', function ($scope) {

})