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
                <h3>House Registration</h3>
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
                          <label class="col-md-4 control-label validate">Mahallu Reg No</label>
                          <div class="col-md-8">
                            <input type="number" min="1" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-4 control-label validate">Owner Name</label>
                          <div class="col-md-8">
                            <input type="text" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-4 control-label validate">House Number</label>
                          <div class="col-md-8">
                            <input type="text" class="form-control round-form">
                          </div>
                        </div>

                      </div>

                      <div class="col-md-4 col-xs-12 item ">

                        <div class="form-group">
                            <label class="col-md-4 control-label validate phone">Phone</label>
                            <div class="col-md-8">
                              <input type="number" class="form-control round-form">
                            </div>
                          </div>

                          <div class="form-group">
                            <label class="col-md-4 control-label validate">Place</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control round-form">
                            </div>
                          </div>

                          <div class="form-group">
                            <label class="col-md-4 control-label validate">Mahallu Block</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control round-form">
                            </div>
                          </div>

                          <div class="form-group">
                            <label class="col-md-4 control-label validate">Post</label>
                            <div class="col-md-8">
                              <input type="text" class="form-control round-form">
                            </div>
                          </div>
                        </div>

                      <div class="col-md-4 col-xs-12 item ">

                        <div class="form-group">
                          <label class="col-md-4 control-label validate pincode">Pincode</label>
                          <div class="col-md-7">
                            <input type="number" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group last">
                          <label class="control-label col-md-3">Image Upload</label>
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
                    <h4 class="mb mode"><i class="fa fa-angle-right"></i> House Details </h4>

                    <div class="row">
                      <div class="col-md-4 col-xs-12 item ">

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">Name <span style="font-size:.7em;">(Panchayath | Muncipality)</span></label>
                          <div class="col-md-6">
                            <input type="text" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">Employed Member No</label>
                          <div class="col-md-6">
                            <input type="number" min="0"  class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">Ward No / Division</label>
                          <div class="col-md-6">
                            <input type="number" min="1" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">Ration Card No.</label>
                          <div class="col-md-6">
                            <input type="number" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">Ration Card Type</label>
                          <div class="col-md-6">
                            <select type="text" class="form-control round-form">
                              <option></option>
                              <option value="78">APL</option>
                              <option value="17">bpl</option>
                              <option value="18">RT02</option>
                            </select>
                          </div>
                        </div>

                      </div>

                      <div class="col-md-4 col-xs-12 item ">

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">Ownership Type</label>
                          <div class="col-md-6">
                            <select class="form-control round-form">
                              <option></option>
                            <option value="15">ownertype2</option>
                            <option value="81">Provided by the employer</option>
                            <option value="80">Rented</option>
                            <option value="79">Self owned</option>
                            </select>
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">House Type</label>
                          <div class="col-md-6">
                            <select class="form-control round-form">
                              <option></option>
                            <option value="87">Concrete terrace roofed, double storeyed</option>
                            <option value="86">Concrete terrace roofed, single storyed</option>
                            <option value="88">Mud house, with thatched roof</option>
                            <option value="90">Tile roofed, double storyed</option>
                            <option value="89">Tile roofed, single storyed</option>
                            <option value="39">TURSE</option>
                            <option value="40">TURSE</option>
                            <option value="41">TURSE</option>
                            </select>
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">House Category</label>
                          <div class="col-md-6">
                            <select class="form-control round-form">
                            <option></option>
                            <option value="12">Luxurious</option>
                            <option value="13">Middle class</option>
                            <option value="1">normal</option>
                            <option value="14">Poor</option>
                            </select>
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">Area (Sq. feet)</label>
                          <div class="col-md-6">
                            <input type="number" step="0.1" min="1" class="form-control round-form">
                          </div>
                        </div>

                        <div class="form-group">
                          <label class="col-md-6 control-label validate">No of Rooms</label>
                          <div class="col-md-6">
                            <input type="number" min="1" class="form-control round-form">
                          </div>
                        </div>

                      </div>

                      <div class="col-md-4 col-xs-12 item ">
                        <div class="form-group">
                          <label class="col-md-5 control-label">House Facilities</label>
                          <div class="col-md-6">
                            <select class="form-control" multiple size="10">
                              <option>AC</option>
                              <option>Computer</option>
                              <option>Electricity</option>
                              <option>Gas</option>
                              <option>Internet</option>
                              <option>Public Tap</option>
                              <option>Public Well</option>
                              <option>Sewing Machine</option>
                              <option>Telephone</option>
                              <option>Television</option>
                              <option>Washing Machine</option>
                              <option>Water Supply</option>
                              <option>Well</option>
                            </select>
                            <span class="help-block">Use CTRL+click to select multiple option</span>
                          </div>
                        </div>
                      </div>
                      
                    </div>
                  </div>

                  <div class="form-panel">
                    <h4 class="mb mode">Financial Details </h4>
                    <div class="row">

                      
                      <div class="col-md-3 col-xs-12 item ">

                        <h5><b><em> Property Details </em></b> </h5>
                        <br>
                          <div class="form-group">
                            <label class="col-md-4 control-label">Vehicles Details</label>
                            <div class="col-md-8">
                              <select class="form-control" multiple size="3">
                                <option>cycle</option>
                                <option>Bike/Scooter</option>
                                <option>Autorickshaw</option>
                                <option>Car</option>
                                <option>Tempo/Pickup</option>
                                <option>Lorry</option>
                              </select>
                              <span class="help-block" style="width:100%;"><input type="text" style="width:100%;" placeholder="others"></span>
                              <span class="help-block">Use CTRL+click to select multiple option</span>
                            </div>
                          </div>

                          <div class="form-group">
                            <label class="col-md-4 control-label validate">Financial Status</label>
                            <div class="col-md-8">
                              <select class="form-control round-form">
                                <option ></option>
                                <option value="13">Middle class</option>
                                <option value="1">Rich</option>
                                <option value="14">Poor</option>
                              </select>
                            </div>
                          </div>

                          <div class="form-group">
                            <label class="col-md-4 control-label">Agriculture Details</label>
                            <div class="col-md-8">
                              <select class="form-control" multiple size="3">
                                <option>Poultry Farm</option>
                                <option>Agriculture(honey)</option>
                                <option>Arecanut</option>
                                <option>Cattle Farm</option>
                                <option>Coconut Farm</option>
                                <option>Goat Farm</option>
                                <option>Paddy Farm</option>
                                <option>Rubber</option>
                                <option>Vegetables</option>
                              </select>
                              <span class="help-block">Use CTRL+click to select multiple option</span>
                            </div>
                          </div>

                      </div>


                      <div class="col-md-9 col-xs-12 item ">

                        <h5><b><em> Income Details &nbsp;&nbsp;&nbsp;<span id="addRow" class="fa fa-plus-circle"></span></em></b> </h5><br>

                        <span id="newRow"></span>

                        <div class="form-group">
                            <div class="row">

                              <div class="col-md-12 col-xs-12 item ">
                                <div class="form-group">
                                  <label class="col-md-4 control-label"></label>
                                  <label class="col-md-2 control-label">Total Income</label>
                                  <label class="col-md-4 control-label">Rs. 0/-</label>
                                </div>
                              </div>
                            </div>
                        </div>

                      </div>
                    </div>
                </div>

                  <div class="form-panel">
                    <h4 class="mb mode"><i class="fa fa-angle-right"></i> Other Details </h4>
                    <div class="row">

                      <div class="col-md-3 col-xs-12 item ">
                        <h5><b><em> Subscription Details </em></b> </h5>
                        <br>

                          <div class="form-group">
                            <label class="col-md-4 control-label">Helping Mahal</label>
                            <div class="col-md-8">
                              <select class="form-control" multiple size="3">
                                <option>Giving Subscription </option>
                                <option>Rice </option>
                                <option>Arecanut </option>
                                <option>Coconut </option>
                                <option>Food </option>
                                
                              </select>
                              <span class="help-block" style="width:100%;"><input type="text" style="width:100%;" placeholder="others"></span>
                              <span class="help-block">Use CTRL+click to select multiple option</span>
                            </div>
                          </div>
                      </div>

                      <div  class="col-md-9 col-xs-12 item ">
                        <h5><b><em> Reading habit </em></b> </h5>
                        <div class="form-group">
                            <div class="col-md-6 col-xs-12 item ">

                              <div class="form-group">
                                <label class="col-md-6 control-label">Malayalam Newspaper</label>
                                <div class="col-md-6">
                                  <input type="text" class="form-control round-form">
                                </div>
                              </div>

                              <div class="form-group">
                                <label class="col-md-6 control-label">English Newspaper</label>
                                <div class="col-md-6">
                                  <input type="text" class="form-control round-form">
                                </div>
                              </div>

                              <div class="form-group">
                                <label class="col-md-6 control-label">PSC Bulletine</label>
                                <div class="col-md-6">
                                  <input type="text" class="form-control round-form">
                                </div>
                              </div>

                              <div class="form-group">
                                <label class="col-md-6 control-label">Malayalam Magazine</label>
                                <div class="col-md-6">
                                  <input type="text" class="form-control round-form">
                                </div>
                              </div>

                            </div>

                            <div class="col-md-6 col-xs-12 item ">

                              <div class="form-group">
                                <label class="col-md-4 control-label">English Magazine</label>
                                <div class="col-md-7">
                                  <input type="text" class="form-control round-form">
                                </div>
                              </div>

                              <div class="form-group">
                                <label class="col-md-4 control-label">Health Magazine</label>
                                <div class="col-md-7">
                                  <input type="text" class="form-control round-form">
                                </div>
                              </div>

                              <div class="form-group">
                                <label class="col-md-4 control-label">Islamic Magazine</label>
                                <div class="col-md-7">
                                  <input type="text" class="form-control round-form">
                                </div>
                              </div>

                              <div class="form-group">
                                <label class="col-md-4 control-label">Children Magazine</label>
                                <div class="col-md-7">
                                  <input type="text" class="form-control round-form">
                                </div>
                              </div>

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
                            <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text">
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
        // add row
        
          $('#nav-accordion .mt a').removeClass('active');
          $('#nav-accordion .sub-menu a:first').addClass('active');
          $('#nav-accordion .sub-menu .sub #house').addClass('active');
        
        $("#addRow").click(function () {
            var html = `<div class='form-group' id='inputFormRow'style='margin-left:5px;margin-right:5px;'>
                <select class='col-md-3 col-xs-3 item form-control round-form' style='width:30%;'>
                  <option></option>
                  <option>ownertype2</option>
                  <option>Provided by the employer</option>
                  <option>Rented</option>
                  <option>Self owned</option>
                </select>
                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='income'  style='width:30%;'>
                <input type='text' class='col-md-3 col-xs-3 form-control round-form' placeholder='details' style='width:30%;'>
                <label class='col-md-1 col-xs-1 control-label'><span id='removeRow' class='fa fa-minus-circle fa-2x'></span></label>
              </div>`;

            $('#newRow').append(html);
        });

        // remove row
        $(document).on('click', '#removeRow', function () {
            $(this).closest('#inputFormRow').remove();
        });
        
                        
    </script>
    
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>
  <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
</body>
</html>




