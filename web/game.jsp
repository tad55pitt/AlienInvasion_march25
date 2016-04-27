<%-- 
    Document   : game
    Created on : Mar 3, 2016, 6:40:53 PM
    Author     : Troy Dinkel
--%>

<%@page import="edu.pitt.is1017.spaceinvaders.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AlienInvasion</title>
        <style>
            #tblAliens{
                position:absolute;
                top:10px;
                left:10px;
            }

            #tblAliens tr td{
                padding:5px
            }
            
            #shipimage{
                position: absolute;
            }
            #bulletimage{
                position: absolute;
            }
            
            body{
                background-image: url(http://wallpapercave.com/wp/pEeUsp1.jpg);
            }

        </style>
        <link rel="shortcut icon" href="">
        <script src = "jssrc/jquery-2.2.2.min.js"></script>
        <script>
            $ship = null;
            var BULLET_WIDTH = 23; 
            var BULLET_HEIGHT = 33;
            var curBulletID = 1;
            var firedBullets = []; // initialize empty array that will hold bullet objects
            var screenWidth = 0;
            var screenHeight = 0;
            
            $(document).ready(function () {
                screenWidth = $(document).width();
                screenHeight = $(document).height();
               
                $(document).keydown(function (e) {
                    console.log(e.which);
                    moveShip(e);
                });
                
                $(window).resize(function(){
                    initElements();
                });
                    
                initElements(); 
               
            });
            
            $tblAliens = null;
            
            function initElements(){
                buildAliens();
                $alien=$('#alien');
                $ship = $('#ship');
                
                $alien.css("top", TOP_MARGIN + "px");
                $alien.css("left",(docWidth / 2 - $alien.width()/2)+"px")
                
                $ship.css("top",(docHeight-$ship.height()-TOP_MARGIN)+"px");
                $ship.css("left",(docWidth/2-$ship.width()/2)+"px");
                
               
                }
            }
            
            function buildAliens(){
                 for (var i = 0; i < 3; i++) {
                    $tr = $('<tr></tr>');
                    for (var j = 0; j < 10; j++) {
                        $td = $('<td></td>');
                        $alien = $('<img>');
                        $alien.attr('#alienimage');
                        $td.append($alien);
                        $tr.append($tr);
                    }

                    $tblAliens.append($tr);
                
            }
            
            function saveAlienPosition(posX,posY){
                var url = "/ws_savescores?x="+posX+"&y"+posY;
                
                
                $.post(url,function(data){
                    
                });
                    
                
                
                
            }
            

            function moveShip(e) {
                switch (e.which) {
                    case 32: // fire
                        createBullet();
                        break;
                    case 37: // left
                        var pos = $ship.position();
                        $ship.css('left', (pos.left - 10) + 'px');
                        break;
                    case 39: // right
                        var pos = $ship.position();
                        $ship.css('left', (pos.left + 10) + 'px');
                        break;
                    default:
                        return; // exit this handler for other keys
                }
            }
            
            
            
            function createBullet(){
                // Create image object
                $bulletObj = $('<img>');
                
                // Set attributes for the image object
                $bulletObj.attr({
                    "id" : "bulletimage" + curBulletID,
                    "src" : "images/bullet.gif"
                });
                
                var initBulletX = $ship.position().left + $ship.width() / 2 - BULLET_WIDTH / 2;
                var initBulletY = $ship.position().top - BULLET_HEIGHT;
                // Set CSS position for the image object
                $bulletObj.css({
                    "position" : "absolute",
                    "width" : BULLET_WIDTH + "px",
                    "height" : BULLET_HEIGHT + "px",
                    "top" : initBulletY + "px",
                    "left" : initBulletX + "px"
                });
                
                $('body').append($bulletObj);
                /*
                 * Create bullet object as a JSON object.  Look carefully at the properties.
                 * intervalID property will store timer interval ID
                 * bulletObj property stores the actual jQuery image object representing
                 * an individual bullet
                 */
                var bullet = {
                    "bulletID" : curBulletID,
                    "intervalID" : 0,
                    "bulletObj" : $bulletObj
                };
                
                // Increment global variable
                curBulletID++;
                
                // Save bullet into a global array
                firedBullets.push(bullet);
                
                /*
                 * This is a major difference from what we did in class.
                 * Note that setInterval can take more than two arguments
                 * Each argument after the time interval is an argument that gets
                 * passed to the moveBullet function.  
                 * See documentation: 
                 * https://developer.mozilla.org/en-US/docs/Web/API/WindowTimers/setInterval
                 */
                bullet.intervalID = setInterval(moveBullet, 100, bullet);
            }
            

            function moveBullet(bullet){
                // Get the jQuery bullet object from the DOM
                $firedBullet = $('#bullet_' + bullet.bulletID);
                
                // Get current Y position
                var posY = $firedBullet.position().top;
                
                // Get new position - move by 10 pixels up along Y-axis
                var newPosY = posY - 10;
                
                // Once the bullet is 5px away from the top, remove it
                if(newPosY > 5){
                    $firedBullet.css("top", newPosY + "px");
                }
                else{
                    /* 
                     * Clear interval - it's easy because the interval is 
                     * now a property of the bullet JSON object
                     */
                    clearInterval(bullet.intervalID);
                    $firedBullet.remove(); // Remove bullet from the DOM
                    firedBullets.shift(); // Remove first element of the bullets array
                }
                
            }

        </script>
    </head>
    <body>
        <table id="tblAliens"></table>
        <img src="images/invader.jpg" id="alienimage"/>
        <img src="images/ship.jpg" id="shipimage"/>
        <img src="images/bullet.gif" id="bulletimage"/>
    </body>
</html>
