<!DOCTYPE html>
<html lang="en">

<head>
  <title></title>
  
  <link href="css/style.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-datepicker/css/datepicker.css" />
  <?php include 'utils/head.php'?>
  
 
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-datetimepicker/datertimepicker.css" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  <style>
      .hour:after,.month:after,.year:after,.minute:after{
        content:" \A ";
            white-space: pre; 
      }
  </style>

</head>

<body>
    <?php include 'utils/header.php'?>
    <section id="main-content">
      <section class="wrapper">
        <div class="row" style="padding-bottom: 0;">
          <div class="col-lg-12 main-chart" id="main">

              <!--HEADING-->
              <div class="border-head" id="home">
                <br>
                <h3><em>NOC Issue Registration</em></h3>
              </div>

              <!--CONTENT-->
              <div class="row">
                <div class="col-md-12 col-xs-12 item">
                  
                <form class="form-horizontal style-form" method="get">
                  <div class="form-panel">
                        <br>
                
                        <div class="row">

                            <div class="col-md-6 col-xs-12 item ">
                            
                                <div class="form-group">
                                    <label class="col-md-4 control-label validate">NOC Reg. No.</label>
                                    <div class="col-md-8">
                                    <div class="input-group input-large">
                                        <span class="input-group-addon round-form">NOCRE</span>
                                        <input type="text" class="form-control round-form" name="to">
                                    </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label validate date-before">Issue Date</label>
                                    <div class="col-md-8">
                                    <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text" value="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label validate">House owner Name</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control round-form">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label validate">House Name</label>
                                    <div class="col-md-8">
                                        <input type="textarea" class="form-control round-form" rows='5'>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label validate">Father's Name</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control round-form">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label validate">Mother's Name</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control round-form">
                                    </div>
                                </div>

                                
            
                            
                                </div>

                            <div class="col-md-6 col-xs-12 item ">
                            <div class="form-group">
                                    <label class="col-md-4 control-label validate">Religious Education</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control round-form">
                                    </div>
                                </div>

                            <div class="form-group">
                                    <label class="col-md-4 control-label validate">Mahallu Address</label>
                                    <div class="col-md-8">
                                        <input type="textarea" class="form-control round-form" rows='5'>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label validate">Mahallu Name</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control round-form">
                                    </div>
                                </div>


                                
                                <div class="form-group">
                                <label class="control-label col-md-4 validate">Nikkah Time</label>
                                <div class="col-md-8">
                                    <input size="16" type="text" readonly class="form_datetime form-control round-form">
                                </div>
                                </div>

                                
                            <div class="form-group">
                                <label class="col-md-4 control-label validate">Mahar Place</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control round-form">
                                </div>
                                </div>

                                <div class="form-group">
                                <label class="col-md-4 control-label validate">Verified By</label>
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


                  </div>
                

                </form>
              </div>

          </div>
        </div>
      </section>

    <?php include 'utils/footer.php' ?>
     <script src="lib/script.js"></script>
    
  <script type="text/javascript">

          $('#nav-accordion .mt a').removeClass('active');
          $('#nav-accordion .sub-menu #register').addClass('active');
          $('#nav-accordion .sub-menu .sub #noc_issue').addClass('active');

    </script>
    
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>
</body>
</html>




