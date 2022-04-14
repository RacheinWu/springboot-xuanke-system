$(function () {
    var i = 0;
    var j = 0;
    $("img").click(function () {
        if(j == 0){
            // $("imt:nth-child(3)").animate({transform:'rotateX(180deg)'});
            if(i == 0){
                $("#letter1").animate({top:'20px'},"slow");
                $("#container").animate({bottom:'00px'},"slow");
                $("img").animate({top:'300px'},'slow');
                i = 1;
            }else {
                $("#letter1").animate({top:'0px'},"slow");
                $("#container").animate({bottom:'-220px'},"slow");
                $("img").animate({top: '120px'},'slow');
                i = 0;
            }
        }
    })
})