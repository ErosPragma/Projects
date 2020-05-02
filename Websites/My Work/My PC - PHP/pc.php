<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title> PC </title>

    <?php include 'header.php' ?>
    <link rel="stylesheet" type="text/css" href="assets/styles-pc.css">

    <?php
      $url_d =  -1;
      $url= 'C:\\';
      if ($_SERVER['REQUEST_METHOD']==='POST')
      {
        if(intval($_POST['index'])<0)
        {
          $url_d = $_POST['slct'];
          switch ($url_d)
          {
            case '-1' : $url = 'C:\\'; break;
            case '-2' : $url = 'D:\\'; break;
            case '-3' : $url = 'E:\\'; break;
          }
        }
        else
        {
          $url = $_POST['url'];
          $folders = explode("\n",trim(shell_exec("dir /b /ad \"$url\"")));
          $url  = $url.$folders[intval($_POST['index'])].'\\';
        }
        //print "NEW URL : ".$url."<br>";
      }
     ?>

    <section id="home">
       <div class="overlay"></div>
         <div class="container">
             <div class="row">
              <div class="col-md-4 col-sm-4">
                <div class="home-info">
                   <div class="panel panel-default">
                     <form action="pc.php" method="post" id='myform'>
                        <input type="text" name="index" id="index" style="display:none;"/>
                         <div class="panel-heading" align='left'>
                           <img src="img/back.png" class="back" alt="BACK" onclick="window.history.back();"/>
                           <div class="select">
                            <select name="slct" id="slct" onmouseover="droplist();" onchange="document.getElementById('myform').submit();">
                              <option <?php if (!isset($url_d) || $url_d == '-1') echo 'selected'; ?> value="-1">C</option>
                              <option <?php if ($url_d == '-2') echo 'selected'; ?> value="-2">D</option>
                              <option <?php if ($url_d == '-3') echo 'selected'; ?> value="-3">E</option>
                            </select>
                            <script type="text/javascript">
                              function droplist() {
                                var e = document.getElementById("slct");
                                var indec = e.options[e.selectedIndex].value;
                                document.getElementById('index').value=indec;
                              }
                            </script>
                           </div>
                            <input type="text" name="url" class="url" value = "<?php print $url; ?>"/>
                           <span class="close"><img src="img/close.png" alt="CLOSE" onclick="location.href='homepage.php';"></span>
                         </div>
                         <div class="panel-body">
                           <div class='container-fluid'>
                             <div class="row">

                           <?php
                              $folders = explode("\n",trim(shell_exec("dir /b /ad \"$url\"")));
                              $no_folder = count($folders)-1;
                              $files = explode("\n",trim(shell_exec("dir /b /a-d \"$url\"")));
                              $no_files = count($files)-1;
                              $no = intval($no_folder) + intval($no_files);
                              $interval = intval($no/3);
                              $interval = (intval($interval)<1)?1:$interval;
                              //print $no.'-'.$interval.'-'.$no_folder."-".$no_files."<br>";
                              $i=0;
                              for (; $i < $no_folder; $i++)
                              {
                                if ($i % $interval == 0)
                                {
                                  if ($i!=0)
                                      print "</div>";
                                  print "<div class='col-md-3 col-sm-3'>";
                                }
                                echo "<button type='submit' class='btn btn-primary  entry' onmouseover='document.getElementById(\"index\").value=$i;'>
                                        <span class='glyphicon glyphicon-folder-open'>&nbsp;$folders[$i]</span>
                                      </button>
                                      <br>";
                              }
                              for (; $i < ($no_folder + $no_files) ; $i++)
                              {
                                if ($i % $interval == 0)
                                {
                                  if ($i!=0)
                                      print "</div>";
                                  print "<div class='col-md-3 col-sm-3'>";
                                }

                                $j = $i-$no_folder;

                                echo "<button type='button' class='btn btn-light entry'>
                                  <span class='glyphicon glyphicon-file'>&nbsp;$files[$j]</span>
                                </button><br>";
                              }
                              /*print "</div>";
                              print_r ($folders);
                              print "<br><br>";
                              print_r ($files);*/
                            ?>

                          </div>
                         </div>
                       </div>
                     </form>

                    </div>
                </div>
              </div>
           </div>
        </div>
    </section>


    <?php include 'footer.php' ?>
