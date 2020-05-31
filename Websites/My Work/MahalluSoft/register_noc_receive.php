<!DOCTYPE html>
<html lang="en">

<head>
  <title></title>
  
  <link href="css/style.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-datepicker/css/datepicker.css" />
  <?php include 'utils/head.php'?>
  <style>
    .col1,.col2{
        width : 45%
    }
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
                <h3>NOC Receive Registration</h3>
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
                                    <label class="col-md-4 control-label validate date-before">Receive Date</label>
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
                                <label class="col-md-4 control-label validate">Mahar Place</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control round-form">
                                </div>
                                </div>

                            
                                </div>

                            <div class="col-md-6 col-xs-12 item ">
                               

                            <div class="form-group">
                                <label class="control-label col-md-4 validate">Nikkah Time</label>
                                <div class="col-md-8">
                                    <input size="16" type="text"  readonly class="form_datetime form-control round-form">
                                </div>
                                </div>
                                <div class="form-group">
                                <label class="col-md-4 control-label validate">verified By</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control round-form">
                                </div>
                                </div>

                                <div class="form-group last">
                                <label class="control-label col-md-3">File</label>
                                <div class="col-md-9 fileuploadbox">
                                <div class='fileupload fileupload-new' data-provides='fileupload'>
                                    <div class='fileupload-new thumbnail' style='width: 200px; height: 150px;'>
                                      <img src='http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image' alt='' />
                                    </div>
                                    <div class='fileupload-preview fileupload-exists thumbnail' style='max-width: 200px; max-height: 150px; line-height: 20px;'>
                                    </div>
                                    <div>
                                      <span class='btn btn-theme02 btn-file'>
                                        <span class='fileupload-new'><i class='fa fa-paperclip'></i> Select image</span>
                                        <span class='fileupload-exists'><i class='fa fa-undo'></i> Change</span>
                                        <input type='file'  class='default' />
                                      </span>
                                      <span class='btn btn-theme04 fileupload-exists file-del' data-dismiss='fileupload'><i class='fa fa-trash-o'></i> Remove</span>
                                    </div>
                                  </div>
                                </div>
                                </div>
                            </div>

                            
                        <div class="col-md-12 col-xs-12 item text-center">
                            <button type="button" class="submit btn btn-round btn-primary">Submit</button>
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
          $('#nav-accordion .sub-menu .sub #noc_receive').addClass('active');
            
    </script>
    
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  
  <script src="lib/advanced-form-components.js"></script>
</body>
</html>




