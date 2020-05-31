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
                <h3><em>Member Registration</em></h3>
              </div>

              <!--CONTENT-->
              <div class="row">
                <div class="col-md-12 col-xs-12 item">
                  
                <form class="form-horizontal style-form" method="get">
                  <div class="form-panel">
                    <h4 class="mb mode"><i class="fa fa-angle-right"></i> Basic Details</h4>
                
                    <div class="row">
                      <div class="col-md-4 col-xs-12 item ">

                        <div class="form-group">
                          <label class="col-md-4 control-label validate">House Name</label>
                          <div class="col-md-8">
                            <input type="text" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-4 control-label validate">Member Name</label>
                          <div class="col-md-8">
                            <input type="text" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-4 control-label validate">Gender</label>
                          <div class="col-md-8">
                            <select class="form-control round-form">
                              <option></option>
                                <option>Male</option>
                                <option>Female</option>
                                <option>Others</option>
                            </select>
                          </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label validate">Blood Group</label>
                            <div class="col-md-8">
                                <select class="form-control round-form">
                                  <option></option>
                                <option>A+</option>
                                <option>B+</option>
                                <option>AB+</option>
                                <option>O+</option>
                                <option>A-</option>
                                <option>B-</option>
                                <option>AB-</option>
                                <option>O-</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-4 control-label email">Email ID</label>
                          <div class="col-md-8">
                            <input type="email" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label validate phone">Mobile Number</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control round-form">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label validate">Relation to House Owner</label>
                            <div class="col-md-8">
                              <select class="form-control round-form">
                                <option></option>
                              </select>
                            </div>
                          </div>

                      </div>

                      <div class="col-md-4 col-xs-12 item ">

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
                          <label class="col-md-4 control-label validate">Marital Status</label>
                          <div class="col-md-8">
                            <select class="form-control round-form">
                                <option></option>
                                <option>Unmarried</option>
                                <option>Widow</option>
                                <option>Married</option>
                                <option>Divorce</option>
                            </select>
                          </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label">Social Services</label>
                            <div class="col-md-8">
                              <select class="form-control" multiple size="3">
                                <option>Islamic Organization</option>
                                <option> Mahallu Service  </option>
                                <option>Politics </option>
                                <option> Voluntary Service </option>
                              </select>
                              <span class="help-block" style="width:100%;"><input type="text" style="width:100%;" placeholder="others"></span>
                              <span class="help-block">Use CTRL+click to select multiple option</span>
                            </div>
                          </div>

                        
                        </div>
                      <div class="col-md-4 col-xs-12 item ">

                        <div class="form-group">
                            <label class="col-md-3 control-label">Talents</label>
                            <div class="col-md-8">
                              <select class="form-control" multiple size="3">
                                <option>Artist </option>
                                <option>Hafizhu </option>
                                <option>Others</option>
                                <option> Poet </option>
                                <option>Singer </option>
                                <option>Speech </option>
                                <option>Sports </option>
                                <option>Writter</option>
                              </select>
                              <span class="help-block" style="width:100%;"><input type="text" style="width:100%;" placeholder="others"></span>
                              <span class="help-block">Use CTRL+click to select multiple option</span>
                            </div>
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
                      
                    </div>
                  </div>
                
                <div class="form-panel">
                    <h4 class="mb mode"><i class="fa fa-angle-right"></i> Professional Details </h4>

                    <div class="row">
                      <div class="col-md-5 col-xs-12 item ">
                      <h5 align="center"><b><em> Educational Details </em></b> </h5>

                      <div class="form-group">
                      <label class="col-md-5 control-label validate">Religious Education</label>
                      <div class="col-md-7">
                        <select type="text" class="form-control round-form">
                          <option></option>
                          <option value="24">Darimi</option>
                          <option value="25">Faisi</option>
                          <option value="381">tester</option>
                          <option value="26">Wafi</option>
                        </select>
                      </div>
                    </div>
                      
                    <div class="form-group"> 
                      <label class="col-md-5 control-label validate">General Education</label>
                      <div class="col-md-7">
                        <select type="text" class="form-control round-form">
                          <option></option>
                            <option value="48">Graduate</option>
                            <option value="123">PhD</option>
                            <option value="47">PLUS TWO</option>
                            <option value="49">Post Graduate</option>
                            <option value="46">SSLC</option>
                          </select>
                      </div>
                    </div>

                    <div id='newRowEdu' style="padding-top:25px;">
                    <div class='form-group' id='inputRowEdu'style='margin-left:5px;margin-right:5px;'>
                        <select class='col-md-3 col-xs-3 item form-control round-form' style='width:25%;'>
                            <option></option>
                            <option>B H MS (HOMIO)</option>
                            <option>B TECH</option>
                            <option>BA</option>
                            <option>BCom</option>
                            <option>BSc</option>
                            <option>M.COM</option>
                            <option>MA</option>
                            <option>MSc</option>
                            <option>PLUS TWO</option>
                            <option>SSLC</option>
                        </select>
                        <select class='col-md-3 col-xs-3 item form-control round-form' style='width:25%;'>
                            <option></option>
                            <option>B com</option>
                            <option>BA</option>
                            <option>Business management</option>
                            <option>Business-to-Business Marketing</option>
                            <option>Civil Engineering</option>
                            <option>Civil Engineering</option>
                            <option>Consumer Behaviour</option>
                            <option>Customer Relationship Management</option>
                            <option>Electrical engineering</option>
                            <option>Financial Management-I</option>
                            <option>IT</option>
                            <option>MA</option>
                            <option>Managing Social Projects</option>
                            <option>Marketing Research</option>
                            <option>Mechanical Engineering.</option>
                        </select>
                        <select class='col-md-3 col-xs-3 item form-control round-form' style='width:25%;'>
                            <option></option>
                            <option>State</option>
                            <option>CBSE</option>
                            <option>ICSE</option>
                        </select>
                        <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='pass out'  style='width:18%;'>
                        <label class='control-label'><span id='addRowEdu' class='fa fa-plus-circle fa-2x'></span></label>
                        </div>
                     </div>

                    </div>

                    <div class="col-md-7 col-xs-12 item ">
                    <h5 align="center"><b><em> Employment Details </em></b> </h5>
                        <div class="form-group">
                        <label class="col-md-3 control-label validate">Employment Status</label>
                        <div class="col-md-9">
                            <select type="text" id="employ" class="form-control round-form">
                            <option></option>
                            <option>Unemployed</option>
                            <option>Native</option>
                            <option>Abroad</option>
                            </select>
                        </div>
                        </div>

                        <div id='unemploy-form-group' class='form-group'>
                            <label class='col-md-3 control-label'>Reason</label>
                            <div class='col-md-9'>
                                <input type='text'  class='form-control round-form'>
                            </div>
                        </div>

                        <div id='employ-form-group' class='form-group' style="display:none">
                            <label class='col-md-2  control-label'>Place</label>
                            <div class='col-md-4'>
                                <input type='text' class='form-control round-form'>
                            </div>

                            <label class='col-md-2 control-label'>Contact No.</label>
                            <div class='col-md-4'>
                                <input type='text' class='form-control round-form'>
                            </div>

                           
                        </div>
                        
                        <div id='newRowEmploy' style="padding-top:25px;display:none;" >
                            <div class='form-group' style='margin-left:5px;margin-right:5px;'>
                                <select class='col-md-3 col-xs-3 item form-control round-form' style='width:16%;'>
                                <option>Government</option>
                                <option>Private</option>
                                <option>Self Employed</option>
                                </select>
                                <select class='col-md-3 col-xs-3 item form-control round-form' style='width:16%;'>
                                    <option>Clerical</option>
                                    <option>Consultant</option>
                                    <option>Daily waged</option>
                                    <option>Manager</option>
                                    <option>manajor</option>
                                </select>
                                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='name'  style='width:20%;'>
                                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='place' style='width:20%;'>
                                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='income' style='width:20%;'>
                                <label class='control-label'><span id='addRowEmploy' class='fa fa-plus-circle fa-2x'></span></label>
                            </div>
                        </div>
                     
                    </div>
                      
                    </div>
                </div>


                  <div class="form-panel">
                    <h4 class="mb mode"><i class="fa fa-angle-right"></i> Other Details </h4>
                    <div class="row">

                      <div class="col-md-4 col-xs-12 item ">
                        <h5 align="center"><b><em> Health Details </em></b> </h5>
                        <br>

                          <div class="form-group">
                            <label class="col-md-4 control-label">Habits</label>
                            <div class="col-md-8">
                              <select class="form-control" multiple size="3">
                                <option>Drugs</option>
                                <option>Drunkard</option>
                                <option>Murukkan</option>
                                <option>Pan</option>
                                <option>Smoking</option>
                              </select>
                              <span class="help-block" style="width:100%;"><input type="text" style="width:100%;" placeholder="others"></span>
                              <span class="help-block">Use CTRL+click to select multiple option</span>
                            </div>
                          </div>

                          <div class="form-group">
                            <label class="col-md-4 control-label">Diseases</label>
                            <div class="col-md-8">
                              <select class="form-control" multiple size="5">
                                <option>Arthritis  </option>
                                <option>Heart Patient</option>
                                <option>Asthma  </option>
                                <option>Blind </option>
                                <option>Blood Plessure </option>
                                <option>Cancer <</option>
                                <option>CataractHandicapped</option>
                                <option>Deaf</option>
                                <option>Diabetic</option>
                                <option>Dumb </option>
                                <option>Kidney Patient</option>
                                <option>mentally retarded</option>
                                <option>Old Age Diseases</option>
                                <option>Skin Diseases </option>                                
                                <option>TB</option>
                                <option>satsified</option>
                              </select>
                              <span class="help-block" style="width:100%;"><input type="text" style="width:100%;" placeholder="others"></span>
                              <span class="help-block">Use CTRL+click to select multiple option</span>
                            </div>
                          </div>

                      </div>

                      <div class="col-md-4 col-xs-12 item " id='newRowAchievement'>
                        <h5 align="center"><b><em> Achievements </em></b> </h5>
                        <br>

                        <div class='form-group' id='rowAchievement'>
                        <div class='col-md-10'>
                            <input type='text' class='form-control round-form'>
                        </div>
                        <label class='col-md-1 control-label'><span id='addAchievement' class='fa fa-plus-circle fa-2x'></span></label>
                        </div>

                        <span id="achievement"></span>

                        
                      </div>

                      <div  class="col-md-4 col-xs-12 item ">
                        <h5 align="center"><b><em> Identity </em></b> </h5>
                        <br>
                        
                        <div class="form-group">
                            <label class="col-md-5 control-label">Identity Card</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control round-form">
                            </div>
                        </div>
                                                
                        <div class="form-group">
                            <label class="col-md-5 control-label">Aadhar Card</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control round-form">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-5 control-label">Pan Card</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control round-form">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-5 control-label">License Card</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control round-form">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-5 control-label">Passport Card</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control round-form">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-5 control-label">Others</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control round-form">
                            </div>
                        </div>
                      </div>


                    </div>
                  </div>
                
                  <div class="form-panel">
                    <div class="row">
                      <br>

                      <div class="col-md-4 col-xs-12 item ">

                          <div class="form-group">
                            <label class="col-md-5 control-label validate">Data Collected By</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control round-form">
                            </div>
                          </div>

                      </div>

                      <div class="col-md-4 col-xs-12 item ">

                          <div class="form-group">
                            <label class="col-md-4 control-label validate date-before">Reg. Date</label>
                            <div class="col-md-8">
                            <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text" value="">
                            </div>
                          </div>

                      </div>

                      <div class="col-md-4 col-xs-12 item ">

                          <div class="form-group">
                            <label class="col-md-4 control-label">Remark</label>
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
          $('#nav-accordion .sub-menu .sub #member').addClass('active');

        $(document).ready(function(){
            $("#employ").change(function(){
                var empl_type = $( "#employ option:selected" ).text();
                $('#employ-form-group').css({"display":"none"});
                $('#unemploy-form-group').css({"display":"none"});
                $('#newRowEmploy').css({"display":"none"});
                if (empl_type.localeCompare('Unemployed')==0)
                    $('#unemploy-form-group').css({"display":"block"});
                else
                {
                    $('#newRowEmploy').css({"display":"block"});
                    $('#employ-form-group').css({"display":"block"});
                }
            });
        });
        // add row
        $("#addRowEmploy").click(function () {
            var html = `<div class='form-group' id='rowEmp' style='margin-left:5px;margin-right:5px;'>
                <select class='col-md-3 col-xs-3 item form-control round-form' style='width:16%;'>
                  <option>Government</option>
                  <option>Private</option>
                  <option>Self Employed</option>
                </select>
                <select class='col-md-3 col-xs-3 item form-control round-form' style='width:16%;'>
                    <option>Clerical</option>
                    <option>Consultant</option>
                    <option>Daily waged</option>
                    <option>Manager</option>
                    <option>manajor</option>
                </select>
                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='name'  style='width:20%;'>
                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='place' style='width:20%;'>
                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='income' style='width:20%;'>
                <label class='control-label'><span id='removeRowEmp' class='fa fa-minus-circle fa-2x'></span></label>
              </div>`;

            $('#newRowEmploy').append(html);
        });

        $("#addRowEdu").click(function () {
            var html = `<div class='form-group' id='rowEdu' style='margin-left:5px;margin-right:5px;'>
                <select class='col-md-3 col-xs-3 item form-control round-form' style='width:25%;'>
                    <option>B H MS (HOMIO)</option>
                    <option>B TECH</option>
                    <option>BA</option>
                    <option>BCom</option>
                    <option>BSc</option>
                    <option>M.COM</option>
                    <option>MA</option>
                    <option>MSc</option>
                    <option>PLUS TWO</option>
                    <option>SSLC</option>
                </select>
                <select class='col-md-3 col-xs-3 item form-control round-form' style='width:25%;'>
                    <option>B com</option>
                    <option>BA</option>
                    <option>Business management</option>
                    <option>Business-to-Business Marketing</option>
                    <option>Civil Engineering</option>
                    <option>Civil Engineering</option>
                    <option>Consumer Behaviour</option>
                    <option>Customer Relationship Management</option>
                    <option>Electrical engineering</option>
                    <option>Financial Management-I</option>
                    <option>IT</option>
                    <option>MA</option>
                    <option>Managing Social Projects</option>
                    <option>Marketing Research</option>
                    <option>Mechanical Engineering.</option>
                </select>
                <select class='col-md-3 col-xs-3 item form-control round-form' style='width:25%;'>
                    <option>State</option>
                    <option>CBSE</option>
                    <option>ICSE</option>
                </select>
                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='pass out'  style='width:18%;'>
                <label class='control-label'><span id='removeRowEdu' class='fa fa-minus-circle fa-2x'></span></label>
              </div>`;

            $('#newRowEdu').append(html);
        });

        $("#addAchievement").click(function(){
            $('#newRowAchievement').append(`<div class='form-group' id='rowAchievement'>
            <div class='col-md-10'>
                <input type='text' class='form-control round-form'>
            </div>
            <label class='col-md-1 control-label'><span id='removeAchievement' class='fa fa-minus-circle fa-2x'></span></label>
            </div>`);
        });

        // remove row
        $(document).on('click', '#removeRowEmp', function () {
            $(this).closest('#rowEmp').remove();
        });

        // remove row
        $(document).on('click', '#removeRowEdu', function () {
            $(this).closest('#rowEdu').remove();
        });

        // remove row
        $(document).on('click', '#removeAchievement', function () {
            $(this).closest('#rowAchievement').remove();
        });

                  
    </script>
    
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>
  <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
</body>
</html>




