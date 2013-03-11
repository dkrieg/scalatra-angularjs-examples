module = angular.module("Twitter.controllers", ["ngResource"])

module.controller "TwitterCtrl", ["$scope", "$resource", ($scope, $resource) ->
  _.extend $scope, {
    searchTerm: "angularjs"
    doSearch: ->
      @twitter = $resource("/twitter/:action",
        {action: "search.json", q:@searchTerm, callback:"JSON_CALLBACK"},
        {get:{method:"JSONP"}}
      ).get()
    isCollapsed: false
  }
]
