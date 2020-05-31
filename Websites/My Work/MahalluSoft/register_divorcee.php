<!DOCTYPE html>
<html lang="en">

<head>
  <title></title>
  
  <link href="css/style.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
  <?php include 'utils/head.php'?>


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
                <h3><em>Divorcee Registration</em></h3>
              </div>

              <!--CONTENT-->
              <div class="row">
                <div class="col-md-12 col-xs-12 item">
                  
                <form class="form-horizontal style-form" method="get">
                  <div class="form-panel">
                      
                  <div class="row" style="padding-top:20px;padding-bottom:0px;">
                    <div class="item">
                    <div class="form-group">
                            
                            <label class="control-label checkbox-inline">
                              <input type="checkbox" id="registered" value="option1"> Is Marriage Register with Mahal
                            </label>
                          </div>
                    </div>
                  </div>
                
                  <div class="row" style="padding:0px 20px 20px 20px;">
                      

                      <div class="col-md-6 col-xs-12 item" style="padding:50px;">

                          <div class="new form-group" style="display:none">
                              <label class="col-md-5 control-label validate">Husband Name</label>
                              <div class="col-md-7">
                                <select class="form-control round-form">
                                    <option></option>
                                </select>
                              </div>
                            </div>

                            <div class="new form-group">
                              <label class="col-md-5 control-label validate">Husband Name</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate">Husband House</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="new form-group" style="display:none">
                              <label class="col-md-5 control-label validate">Wife Name</label>
                              <div class="col-md-7">
                                <select class="form-control round-form">
                                    <option></option>
                                </select>
                              </div>
                            </div>

                            <div class="new form-group">
                              <label class="col-md-5 control-label validate">Wife Name</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate">Wife House</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                              </div>
                            </div>

                        
                      </div>

                      <div class="col-md-6 col-xs-12 item" style="padding:50px;">


                          <div class="form-group">
                              <label class="col-md-5 control-label validate date-span">Marriage Date</label>
                              <div class="col-md-7">
                              <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text" id="marriage_date">
                              </div>
                            </div>
                          <div class="form-group">
                              <label class="col-md-5 control-label validate">Divorce Type</label>
                              <div class="col-md-7">
                                    <select class="form-control round-form">
                                    <option></option>
                                    <option value="1">1</option>
                                </select>
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate date-span">Divorce Date</label>
                              <div class="col-md-7">
                              <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text" id="divorce_date">
                              </div>
                            </div>

                            <div class="form-group">
                              <label class="col-md-5 control-label validate">Verified By</label>
                              <div class="col-md-7">
                                <input type="text" class="form-control round-form">
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
          $('#nav-accordion .sub-menu .sub #divorcee').addClass('active');

          $(document).ready(function(){
              $('#registered[type="checkbox"]').click(function(){
                    $('.new').toggle();
              });
          });
        
            
    </script>
    
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>
</body>
</html>




