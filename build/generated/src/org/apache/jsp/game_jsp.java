package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.pitt.is1017.spaceinvaders.User;

public final class game_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>AlienInvasion</title>\n");
      out.write("        <style>\n");
      out.write("            #tblAliens{\n");
      out.write("                position:absolute;\n");
      out.write("                top:10px;\n");
      out.write("                left:10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #tblAliens tr td{\n");
      out.write("                padding:5px\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            body{\n");
      out.write("                background-image: url(http://wallpapercave.com/wp/pEeUsp1.jpg);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"\">\n");
      out.write("        <script src = \"jssrc/jquery-2.2.2.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $ship = null;\n");
      out.write("            var BULLET_WIDTH = 23; \n");
      out.write("            var BULLET_HEIGHT = 33;\n");
      out.write("            var curBulletID = 1;\n");
      out.write("            var firedBullets = []; // initialize empty array that will hold bullet objects\n");
      out.write("            var screenWidth = 0;\n");
      out.write("            var screenHeight = 0;\n");
      out.write("            \n");
      out.write("            $(document).ready(function () {\n");
      out.write("                screenWidth = $(document).width();\n");
      out.write("                screenHeight = $(document).height();\n");
      out.write("               \n");
      out.write("                $(document).keydown(function (e) {\n");
      out.write("                    console.log(e.which);\n");
      out.write("                    moveShip(e);\n");
      out.write("                });\n");
      out.write("                initElements(); \n");
      out.write("               \n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            $tblAliens = null;\n");
      out.write("            \n");
      out.write("            function initElements(){\n");
      out.write("                $ship = $('#shipimage');\n");
      out.write("                $ship.css('top', (screenHeight - $ship.height() - 30) + \"px\");\n");
      out.write("                $ship.css('left', (screenWidth / 2 - $ship.width() / 2) + \"px\");\n");
      out.write("                $alien = $('#alienimage');\n");
      out.write("                $bullet = $('#bulletimage');\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                $ship.css(\"top\",(docHeight-$ship.height()-TOP_MARGIN)+\"px\");\n");
      out.write("                $ship.css(\"left\",(docWidth/2-$ship.width()/2)+\"px\");\n");
      out.write("                \n");
      out.write("                for (var i = 0; i < 3; i++) {\n");
      out.write("                    $tr = $('<tr></tr>');\n");
      out.write("                    for (var j = 0; j < 10; j++) {\n");
      out.write("                        $td = $('<td></td>');\n");
      out.write("                        $alien = $('<img>');\n");
      out.write("                        $alien.attr('src', 'images/invader.jpg');\n");
      out.write("                        $td.append($alien);\n");
      out.write("                        $tr.append($tr);\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    $tblAliens.append($tr);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write("            function moveShip(e) {\n");
      out.write("                switch (e.which) {\n");
      out.write("                    case 32: // fire\n");
      out.write("                        createBullet();\n");
      out.write("                        break;\n");
      out.write("                    case 37: // left\n");
      out.write("                        var pos = $ship.position();\n");
      out.write("                        $ship.css('left', (pos.left - 10) + 'px');\n");
      out.write("                        break;\n");
      out.write("                    case 39: // right\n");
      out.write("                        var pos = $ship.position();\n");
      out.write("                        $ship.css('left', (pos.left + 10) + 'px');\n");
      out.write("                        break;\n");
      out.write("                    default:\n");
      out.write("                        return; // exit this handler for other keys\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            function createBullet(){\n");
      out.write("                // Create image object\n");
      out.write("                $bulletObj = $('<img>');\n");
      out.write("                \n");
      out.write("                // Set attributes for the image object\n");
      out.write("                $bulletObj.attr({\n");
      out.write("                    \"id\" : \"bulletimage\" + curBulletID,\n");
      out.write("                    \"src\" : \"images/bullet.gif\"\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                var initBulletX = $ship.position().left + $ship.width() / 2 - BULLET_WIDTH / 2;\n");
      out.write("                var initBulletY = $ship.position().top - BULLET_HEIGHT;\n");
      out.write("                // Set CSS position for the image object\n");
      out.write("                $bulletObj.css({\n");
      out.write("                    \"position\" : \"absolute\",\n");
      out.write("                    \"width\" : BULLET_WIDTH + \"px\",\n");
      out.write("                    \"height\" : BULLET_HEIGHT + \"px\",\n");
      out.write("                    \"top\" : initBulletY + \"px\",\n");
      out.write("                    \"left\" : initBulletX + \"px\"\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $('body').append($bulletObj);\n");
      out.write("                /*\n");
      out.write("                 * Create bullet object as a JSON object.  Look carefully at the properties.\n");
      out.write("                 * intervalID property will store timer interval ID\n");
      out.write("                 * bulletObj property stores the actual jQuery image object representing\n");
      out.write("                 * an individual bullet\n");
      out.write("                 */\n");
      out.write("                var bullet = {\n");
      out.write("                    \"bulletID\" : curBulletID,\n");
      out.write("                    \"intervalID\" : 0,\n");
      out.write("                    \"bulletObj\" : $bulletObj\n");
      out.write("                };\n");
      out.write("                \n");
      out.write("                // Increment global variable\n");
      out.write("                curBulletID++;\n");
      out.write("                \n");
      out.write("                // Save bullet into a global array\n");
      out.write("                firedBullets.push(bullet);\n");
      out.write("                \n");
      out.write("                /*\n");
      out.write("                 * This is a major difference from what we did in class.\n");
      out.write("                 * Note that setInterval can take more than two arguments\n");
      out.write("                 * Each argument after the time interval is an argument that gets\n");
      out.write("                 * passed to the moveBullet function.  \n");
      out.write("                 * See documentation: \n");
      out.write("                 * https://developer.mozilla.org/en-US/docs/Web/API/WindowTimers/setInterval\n");
      out.write("                 */\n");
      out.write("                bullet.intervalID = setInterval(moveBullet, 100, bullet);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("\n");
      out.write("            function moveBullet(bullet){\n");
      out.write("                // Get the jQuery bullet object from the DOM\n");
      out.write("                $firedBullet = $('#bullet_' + bullet.bulletID);\n");
      out.write("                \n");
      out.write("                // Get current Y position\n");
      out.write("                var posY = $firedBullet.position().top;\n");
      out.write("                \n");
      out.write("                // Get new position - move by 10 pixels up along Y-axis\n");
      out.write("                var newPosY = posY - 10;\n");
      out.write("                \n");
      out.write("                // Once the bullet is 5px away from the top, remove it\n");
      out.write("                if(newPosY > 5){\n");
      out.write("                    $firedBullet.css(\"top\", newPosY + \"px\");\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    /* \n");
      out.write("                     * Clear interval - it's easy because the interval is \n");
      out.write("                     * now a property of the bullet JSON object\n");
      out.write("                     */\n");
      out.write("                    clearInterval(bullet.intervalID);\n");
      out.write("                    $firedBullet.remove(); // Remove bullet from the DOM\n");
      out.write("                    firedBullets.shift(); // Remove first element of the bullets array\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table id=\"tblAliens\"></table>\n");
      out.write("        <img src=\"images/invader.jpg\" id=\"alienimage\"/>\n");
      out.write("        <img src=\"images/ship.jpg\" id=\"shipimage\"/>\n");
      out.write("        <img src=\"images/bullet.gif\" id=\"bulletimage\"/>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
