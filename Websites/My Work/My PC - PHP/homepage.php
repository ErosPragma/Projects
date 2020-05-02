<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>My PC</title>
    <?php include 'header.php' ?>


<!-- HOME -->
<section id="home">
   <div class="overlay"></div>
     <div class="container">
        <div class="row">

           <?php include 'date-time.php' ?>

           <div class="col-md-4 col-sm-4">
              <div class="home-info">
                <a href="pc.php" class="subscribe-form">
                  <img src="img/pc.png" alt="" width="250px" height="200px"/>
                  <h3>My PC</h3>
                </a>
              </div>
           </div>

           <div class="col-md-4 col-sm-4">
              <div class="home-info">
                <a href="notes.php" class="subscribe-form">
                   <img src="img/notes.png" alt="" width="250px" height="200px"/>
                   <h3>Take Notes</h3>
                 </a>
              </div>
           </div>

           <div class="col-md-4 col-sm-4">
              <div class="home-info">
                <a href="share.php" class="subscribe-form">
                   <img src="img/share.png" alt="" width="250px" height="200px"/>
                   <h3>Share</h3>
                 </a>
              </div>
           </div>

       </div>
    </div>
</section>

<?php include 'footer.php' ?>
