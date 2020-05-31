<!DOCTYPE html>
<html lang="en">

<head>
  <title></title>
  
  <link href="css/style.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
  <?php include 'utils/head.php'?>
  <style>
    .col1,.col2{
        width : 45%
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
                <h3>Minutes Registration</h3>
              </div>

              <!--CONTENT-->
              <div class="row">
                <div class="col-md-12 col-xs-12 item">
                  
                <form class="form-horizontal style-form" method="get">
                  <div class="form-panel">
                <br>
                
                    <div class="row">

                      <div class="col-md-5 col-xs-12 item ">
                      
                      <h5 align="center"><b><em> Basic Details </em></b> </h5>
                      <br>

                        <div class="form-group">
                          <label class="col-md-4 control-label validate">Minutes ID</label>
                          <div class="col-md-8">
                            <div class="input-group input-large">
                                <span class="input-group-addon round-form">IMM-138</span>
                                <input type="text" class="form-control round-form" name="to">
                            </div>
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-4 control-label validate">Committee Name</label>
                          <div class="col-md-8">
                            <select class="form-control round-form">
                            <option></option>
                            </select>
                          </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label validate date-before"> Date</label>
                            <div class="col-md-8">
                            <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text" value="">
                            </div>
                          </div>

                          <div class="form-group">
                          <label class="col-md-4 control-label validate">Agenda</label>
                          <div class="col-md-8">
                            <textarea class="form-control" rows='3' style="resize:none;"></textarea>
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-4 control-label validate">Decision</label>
                          <div class="col-md-8">
                          <textarea class="form-control" rows='3' style="resize:none;"></textarea>
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

                      <div class="col-md-7 col-xs-12 item ">
                      
                        <h5 align="center"><b><em> Attendence </em></b> </h5>
                        <div id="display-table" >
                            <div>
                                <!-- page start-->
                                <div class="content-panel">

                                <div class="adv-table" style="padding-right:20px">
                                    <table cellpadding="0" cellspacing="0" border="0" style=" table-layout: fixed; margin-bottom: 0px;" class="display table table-bordered" id="hidden-table-info">
                                    <thead>
                                        <tr>
                                        <th class="col1">Member</th>
                                        <th class="col2">Designation</th>
                                        <th></th>
                                        </tr>
                                    </thead>
                                    </table>
                                </div>
                                <div class="adv-table" style="overflow:scroll;height:250px;">
                                    <table cellpadding="0" cellspacing="0" border="0" style=" table-layout: fixed; "  class="display table table-bordered">
                                    <tbody>
                                        <tr class="gradeX">
                                        <td class="col1"></td>
                                        <td class="col2"></td>
                                        <td><input type="checkbox" id="inlineCheckbox1" value="option1"></td>
                                        </tr>

                                    </tbody>
                                    </table>
                                </div>
                                </div>
                                <!-- page end-->
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
          $('#nav-accordion .sub-menu .sub #minutes').addClass('active');

             
    </script>
    
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>
  <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
</body>
</html>




