<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <title> Share </title>

    <?php include 'header.php' ?>
    <link rel="stylesheet" type="text/css" href="assets/styles-share.css">


    <section id="home">
       <div class="overlay"></div>
         <div class="container">
             <div class="row">

               <div class='col-md-12 col-sm-12'>
                <div class='home-info'>

                  <script>
                    function jump(e,gid)
                    {
                      var links = document.getElementsByClassName("nav-link");
                      for (var i = 0; i < links.length; i++)
                        links[i].className = links[i].className.replace(" active", "");

                      var content = document.getElementsByClassName("card-body");
                      for (var i = 0; i < content.length; i++)
                        content[i].style.display = "none";

                        document.getElementById(gid).style.display = "block";
                        e.currentTarget.className += " active";
                    }
                  </script>

                  <div class="card text-center">
                    <div class="card-header">
                      <ul class="nav nav-tabs card-header-tabs">
                        <li class="nav-item">
                          <a class="nav-link active" onclick="jump(event,'upload-history')" style="font-size:1.75em;">Upload History</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" onclick="jump(event,'upload')" style="font-size:1.75em;">Upload</a>
                        </li>
                      </ul>
                    </div>

                    <?php
                    if(isset($_POST['upload']))
                    {
                      $countfiles = count($_FILES['uploaded_file']['name']);

                      for($j=0;$j<$countfiles;$j++)
                      {

                           $filename = $_FILES['uploaded_file']['name'][$j];
                          $path = "../../uploads/";
                          $file = $path . $_FILES['uploaded_file']['name'][$j];
                          $i=0;
                          $str="";
                          while (file_exists($file))
                          {
                            $file = $path ."($i)" . $_FILES['uploaded_file']['name'][$j];
                            $i++;
                            $str = "($i)";
                          }
                          $_FILES['uploaded_file']['name'][$j] = $str . $_FILES['uploaded_file']['name'][$j];


                          $file = fopen("../../uploads/upload-log.txt","a");
                          fprintf($file,"%s**%s**%s\n",date("Y-m-d"),$_FILES['uploaded_file']['name'][$j],round($_FILES['uploaded_file']['size'][$j]/1024,3) .' KB');
                          fclose($file);
                          $path = $path . basename( $_FILES['uploaded_file']['name'][$j]);
                          move_uploaded_file($_FILES['uploaded_file']['tmp_name'][$j], $path);
                        }
                    }
                    ?>
                    <script>
                        $(document).ready(function(){
                            $('input[type="file"]').change(function(e){
                                var fileName = e.target.files[0].name;
                                $('#upload-msg').html('The files has been selected.');
                                $('#upload-btn').show();
                            });
                        });
                    </script>

                    <div class="card-body" id='upload' style="display:none;">
                      <div style="width:80vw;height:60vh;">
                        <form id="form-upload" enctype="multipart/form-data" action="share.php" method="POST">
                          <input type="file" name="uploaded_file[]" multiple>
                          <p id="upload-msg" style="font-size:1.5em">Drag your files here or click in this area.</p>
                          <button type="submit" name="upload" id="upload-btn" style="display:none;">Upload</button>
                        </form>
                      </div>

                    </div>
                    <?php
                    //*************************************************
                      if (isset($_POST['deleteall']))
                      {
                        $log = explode("\n",file_get_contents("../../uploads/upload-log.txt"));
                        for ($i=0; $i < count($log) ; $i++)
                        {
                          if (strlen($log[$i])==0)
                              continue;
                          $fields = explode("**",$log[$i]);
                          unlink('../../uploads/'.$fields[1]);
                        }
                        unlink('../../uploads/upload-log.txt');
                        file_put_contents('../../uploads/upload-log.txt',"");
                      }
                      if (isset($_POST['delete']))
                        {
                          $name = $_POST['name'];
                          $log = explode("\n",file_get_contents("../../uploads/upload-log.txt"));
                          $new_log = "";
                          for ($i=0; $i < count($log) ; $i++)
                          {
                            if (strlen($log[$i])==0)
                                continue;
                            $fields = explode("**",$log[$i]);
                            if (strcmp($fields[1],$name)!==0)
                              $new_log .= sprintf("%s**%s**%s\n",$fields[0],$fields[1],$fields[2]);
                          }
                          unlink('../../uploads/upload-log.txt');
                          unlink('../../uploads/'.$name);
                          file_put_contents('../../uploads/upload-log.txt',$new_log);
                        }

                     ?>
                    <div class="card-body" id='upload-history' style="display:block;">
                      <div class="limiter">
                        <div class="container-table100">
                          <div class="wrap-table100">
                            <div class="table100">
                              <table>
                                <thead>
                                  <tr class="table100-head">
                                    <th class="column1">Date</th>
                                    <th class="column2">Filename</th>
                                    <th class="column3">File size</th>
                                    <th class="column4"><form method='post'>
                                     <button type='submit' name='deleteall'>
                                       <span class='glyphicon glyphicon-trash'><br>
                                         <span  style="font-size:0.6em">ALL</span></span>
                                     </button>
                                   </form></th>
                                  </tr>
                                </thead>
                              </table>
                            </div>

                            <div id="scroll" class="table100">
                              <table>
                                <tbody>
                                  <?php
                                      $content = file_get_contents("../../uploads/upload-log.txt");
                                      $home = explode("\n",$content);
                                      for ($i=0; $i < count($home) ; $i++)
                                      {
                                        if (strlen($home[$i])==0)
                                            break;
                                        $fields = explode("**",$home[$i]);
                                        print "<tr>
                                        <td class='column1'> $fields[0] </td>
                                        <td class='column2'><a target='_blank' href='../../uploads/$fields[1]'>$fields[1]</a></td>
                                        <td class='column3'> $fields[2] </td>
                                        <td  class='column4'><form method='post'>
                                         <input type='text' name='name' value='$fields[1]' style='display:none;'/>
                                         <button type='submit' name='delete'>
                                           <span class='glyphicon glyphicon-trash'></span>
                                         </button>
                                       </form></td>
                                        </tr>";
                                    }
                                   ?>

                                </tbody>
                              </table>
                            </div>

                          </div>
                        </div>
                      </div>
                    </div>

                  </div>
                  <p>
                    <br>

                    <a href='homepage.php'><button type='button' class='btn btn-primary btn-lg'>BACK</button></a>
                  </p>
                </div>
                </div>
             </div>

         </div>

    </section>



<?php include 'footer.php' ?>
