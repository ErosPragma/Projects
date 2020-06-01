<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <title> My Notes </title>

    <?php include 'header.php' ?>


    <?php   //Necessary Functions
      function view_notes()
      {
        $note_list = explode("\n",trim(shell_exec("dir /b /a notes")));
        if (strlen(trim(shell_exec("dir /b /a notes")))==1)
            $note_list = [];

        for ($i=0; $i < count($note_list); $i++)
        {

          $note_name = explode(".",$note_list[$i])[0];
          if (strlen($note_list[$i])>1)
          {
            $note_url = "notes/".$note_list[$i];
            $note_content = file_get_contents($note_url);
          }
          else
          {
            $note_url = "notes/newfile.txt";
            $note_content = "";
          }

          if($i%2==0)
          {
            if ($i==2)
                print "</div>
                      <a href='homepage.php'><button type='button' class='btn btn-primary btn-lg'>BACK</button></a>
                    </div>
                 </div>
                ";
            else if ($i!=0)
                print "</div>
                      <a href='#home'><button type='button' class='btn btn-primary btn-lg'>GOTO TOP</button></a>
                    </div>
                 </div>
                ";

            print "<div class='col-md-12 col-sm-12'>
                <div class='home-info'>
                <form method='post' action='notes.php'>
                <button type='submit' name='add-note' class='btn btn-warning'>ADD NOTE</button>
                </form>
                <br>
                <div class='row row-cols-1 row-cols-md-2'>";
          }

          print "
          <div class='col mb-4'>

            <div class='card'>
              <div class='card-body'>
                <form method='post'  action='notes.php'>
                  <input type='text' class='card-title' width='100%' name='note-$i-name' value='$note_name'></input>
                  <p class='card-text'>
                    <textarea type='text' name='note-$i-note' size='100%' cols='150' rows='7' style='font-family: Arial;font-size: 11pt;width:100%;height:100%;resize:none;'>".$note_content."</textarea>
                  </p>
                  <button type='submit' name='save-$i-note' class='btn btn-success'>SAVE NOTE</button>
                  <button type='submit' name='del-$i-note' class='btn btn-danger'>DELETE NOTE</button>
                </form>
              </div>
            </div>
          </div>
          ";
        }
        if (count($note_list)<3)
              print "</div>
                    <a href='homepage.php'><button type='button' class='btn btn-primary btn-lg'>BACK</button></a>
                  </div>
               </div>
              ";
        else
              print "</div>
                  <a href='#home'><button type='button' class='btn btn-primary btn-lg'>GOTO TOP</button></a>
                  </div>
               </div>";
      }

      function add_note($name,$content){
          $file = fopen("notes/".$name,"w");
          fwrite($file,$content);
          fclose($file);

      }

      function del_note($no){
          $note_list = explode("\n",trim(shell_exec("dir /b /a notes")));
          if (strlen($note_list[$no])>1)
            unlink("notes/".$note_list[$no]);
      }

      function save_note($no,$name,$content){
          $note_list = explode("\n",trim(shell_exec("dir /b /a notes")));
          $note_name = explode(".",$note_list[$no])[0];
          if (strlen($note_list[$no])<=1)
              $note_url = "notes/".$name.".txt";
          else
              $note_url = "notes/".$note_list[$no];

          file_put_contents($note_url,$content);

          if ($note_list[$no] != $name )
          {
            rename($note_url,"notes/".$name.".txt");
            $note_url = "notes/".$note_list[$no];
          }
      }

      $note_list = explode("\n",trim(shell_exec("dir /b /a notes")));
      if (!empty($_POST))
      {
        for ($i=0; $i < count($note_list) ; $i++)
        {
          if (isset($_POST['save-'.$i.'-note']))
            save_note($i,$_POST['note-'.$i.'-name'],$_POST['note-'.$i.'-note']);
          else if (isset($_POST['del-'.$i.'-note']))
            del_note($i);
          else if (isset($_POST['add-note']))
            add_note("newfile.txt","");
        }
      }
     ?>

    <section id="home">
       <div class="overlay"></div>
         <div class="container">
             <div class="row">

                <?php view_notes(); ?>

           </div>
        </div>
    </section>


<?php include 'footer.php' ?>
