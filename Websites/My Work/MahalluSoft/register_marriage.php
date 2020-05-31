<!DOCTYPE html>
<html lang="en">

<head>
  <title></title>
  
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-datepicker/css/datepicker.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-daterangepicker/daterangepicker.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-timepicker/compiled/timepicker.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-datetimepicker/css/datetimepicker.css" />   
  
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">

  <?php include 'utils/head.php'?>

  <style>
    @media (min-width: 992px){
      #col3 {
          width: 28%;
      }
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
                <h3><em>Marriage Registration</em></h3>
              </div>

              <!--CONTENT-->
              <div class="row">
                <div class="col-md-12 col-xs-12 item">
                  
                <form class="form-horizontal style-form" method="get">
                  <div class="form-panel">
                
                  <div class="row" style="padding:20px;">
                      
                      <div class="col-md-4 col-xs-12 item " style="padding:5px;border: 1px groove;margin: 10px;box-shadow: 2px 10px #888888;">
                      
                        <h5 align="center"><b><em>Groom Details </em></b> </h5>
                        <br>

                        <div class="form-group">
                            
                            <label class="control-label checkbox-inline">
                              <input type="checkbox" id="groomid" value="option1"> Member of Mahal
                            </label>
                          </div>

                        <span class="groom_member" style="display:none;">

                            <div class="form-group">
                              <label class="col-md-4 control-label validate">House Name</label>
                              <div class="col-md-8">
                                <select class="form-control round-form">
                                  <option></option>
                                </select>
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-4 control-label validate">Name</label>
                              <div class="col-md-8">
                              <select class="form-control round-form">
                                  <option></option>
                                </select>
                              </div>
                            </div>
                        </span>

                        <span class="groom_nonmember">

                            <div class="form-group">
                              <label class="col-md-4 control-label validate">House Name</label>
                              <div class="col-md-8">
                              <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-4 control-label validate">Name</label>
                              <div class="col-md-8">
                              <input type="text" class="form-control round-form">
                              </div>
                            </div>
                        </span>


                        <div class="form-group">
                          <label class="col-md-4 control-label validate">Age</label>
                          <div class="col-md-8">
                            <input type="number" min="18" class="form-control round-form">
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

                        <div class="form-group">
                            <label class="col-md-4 control-label validate">Place</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control round-form">
                            </div>
                        </div>
                          <div class="form-group">
                            <label class="col-md-4 control-label validate">Address</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control round-form">
                            </div>
                          </div>

                          <div class="form-group">
                            <label class="col-md-4 control-label validate">Mahal Details</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control round-form">
                            </div>
                          </div>


                          <div class="form-group">
                            
                            <label class="control-label checkbox-inline">
                              <input type="checkbox" id="inlineCheckbox1" value="option1"> First marriage
                            </label>
                          </div>

                          <div class="form-group last">
                            <label class="control-label col-md-3">Image</label>
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

                      <div class="col-md-4 col-xs-12 item " style=" padding:5px;border: 1px groove;margin: 10px;box-shadow: 2px 10px #888888;">
                      
                        <h5 align="center"><b><em>Bride Details </em></b> </h5>
                        <br>

                          <div class="form-group">
                              
                              <label class="control-label checkbox-inline">
                                <input type="checkbox" id="brideid" value="option1"> Member of Mahal
                              </label>
                            </div>

                          <span class="bride_member" style="display:none;">

                              <div class="form-group">
                                <label class="col-md-4 control-label validate">House Name</label>
                                <div class="col-md-8">
                                  <select class="form-control round-form">
                                    <option></option>
                                  </select>
                                </div>
                              </div>

                              <div class="form-group">
                                <label class="col-md-4 control-label validate">Name</label>
                                <div class="col-md-8">
                                <select class="form-control round-form">
                                    <option></option>
                                  </select>
                                </div>
                              </div>
                          </span>

                          <span class="bride_nonmember">

                              <div class="form-group">
                                <label class="col-md-4 control-label validate">House Name</label>
                                <div class="col-md-8">
                                <input type="text" class="form-control round-form">
                                </div>
                              </div>

                              <div class="form-group">
                                <label class="col-md-4 control-label validate">Name</label>
                                <div class="col-md-8">
                                <input type="text" class="form-control round-form">
                                </div>
                              </div>
                          </span>


                          <div class="form-group">
                            <label class="col-md-4 control-label validate">Age</label>
                            <div class="col-md-8">
                              <input type="number" min="18" class="form-control round-form">
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

                          <div class="form-group">
                              <label class="col-md-4 control-label validate">Place</label>
                              <div class="col-md-8">
                                  <input type="text" class="form-control round-form">
                              </div>
                          </div>
                            <div class="form-group">
                              <label class="col-md-4 control-label validate">Address</label>
                              <div class="col-md-8">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-4 control-label validate">Mahal Details</label>
                              <div class="col-md-8">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>


                            <div class="form-group">
                              
                              <label class="control-label checkbox-inline">
                                <input type="checkbox" value="option1"> First marriage
                              </label>
                            </div>

                            <div class="form-group last">
                            <label class="control-label col-md-3">Image</label>
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

                      <div class="col-md-3 col-xs-12 item " id="col3">
                         <br>
                         <h5 align="center"><b><em>Marriage Details </em></b> </h5>
                        <br>


                            <div class="form-group">
                              <label class="col-md-5 control-label validate">Reg No.</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate">Mahar Details</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate">Witness 1</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate">Witness 2</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate">Guardian</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate date-before">Date</label>
                              <div class="col-md-7">
                              <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text">
                              </div>
                            </div>
                        
                      </div>

                      
                      <div class="col-md-12 col-xs-12 item text-center" style="margin:15px;">
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
          $('#nav-accordion .sub-menu .sub #marriage').addClass('active');

          $(document).ready(function(){
              $('#groomid[type="checkbox"]').click(function(){
                    $('.groom_member').toggle();
                    $('.groom_nonmember').toggle();
              });
          });

          $(document).ready(function(){
              $('#brideid[type="checkbox"]').click(function(){
                    $('.bride_member').toggle();
                    $('.bride_nonmember').toggle();
              });
          });


    </script>
    
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-daterangepicker/daterangepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>
</body>
</html>




