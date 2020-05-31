<!DOCTYPE html>
<html lang="en">

<head>
  <title>Mahallu Soft - Search</title>
  <?php include 'utils/head.php'?>
  

</head>

<body>
    <?php include 'utils/header.php'?>
    
    <section id="main-content">
      <section class="wrapper">
        <div class="row mt">
          <div class="col-lg-12" id="main">

            <!--HEADING-->
            <div class="border-head" id="home">
                <br>
                <h3><em>Institution Registration</em></h3>
              </div>

            <!--CONTENT-->
            <div class="form-panel" style="height:70vh;padding-top:50px;">
              <form class="form-horizontal style-form" method="get">
              
                <div class="row">
                  <div class="col-md-1 col-xs-12 item "></div>
                  <div class="col-md-5 col-xs-12 item ">

                    <div class="form-group">
                      <label class="col-md-4 control-label validate">Institution Type</label>
                      <div class="col-md-8">
                        <select class="form-control round-form">
                            <option></option>
                        </select>
                      </div>
                    </div>
                      
                    <div class="form-group">
                      <label class="col-md-4 control-label validate">Name</label>
                      <div class="col-md-8">
                        <input type="text" class="form-control round-form">
                      </div>
                    </div>

                    
                  </div>
                  <div class="col-md-5 col-xs-12 item ">

                    <div class="form-group">
                      <label class="col-md-4 control-label validate">Registration No.</label>
                      <div class="col-md-8">
                        <input type="number" min="1" class="form-control round-form">
                      </div>
                    </div>
                     
                    <div class="form-group">
                      <label class="col-md-4 control-label">Description</label>
                      <div class="col-md-8">
                        <input type="text" class="form-control round-form">
                      </div>
                    </div>

                  </div>
  

                  <div class="col-md-12 col-xs-12 item text-center">
                      <button type="button" class="submit btn btn-round btn-primary">SUBMIT</button>
                      <button type="button" class="reset btn btn-round btn-default">RESET</button>
                  </div>

                </div>
              </form>
            </div>

          </div>
        </div>

      </section>

    <?php include 'utils/footer.php' ?>
    
    <script src="lib/script.js"></script>
    <script>
          $('#nav-accordion .mt a').removeClass('active');          
            $('#nav-accordion .sub-menu #register').addClass('active');
            $('#nav-accordion .sub-menu .sub #institution').addClass('active');

    </script>
      <!--script for this page-->
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>

</body>
</html>
