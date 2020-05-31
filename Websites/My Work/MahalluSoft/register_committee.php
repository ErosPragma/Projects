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
                <h3><em>Committee Registration</em></h3>
              </div>


            <!--CONTENT-->
            <div class="form-panel">
              <h4 class="mb mode"><i class="fa fa-angle-right"></i> Edit Committee </h4>
              <form class="form-horizontal style-form" method="get" style="display:none;">
              
                <div class="row">
                  <div class="col-md-5 col-xs-12 item ">
                        <h5 align="center"><b><em> Committee Details </em></b> </h5>
                        <br>

                    <div class="form-group">
                      <label class="col-md-4 control-label validate">Name</label>
                      <div class="col-md-8">
                        <select class="form-control round-form">
                            <option></option>
                        </select>
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-md-4 control-label validate date-before">Formed Date</label>
                      <div class="col-md-8">
                        <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-md-4 control-label validate">Validity</label>
                      <div class="col-md-8">
                        <input type="text" class="form-control round-form">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-md-4 control-label">Description</label>
                      <div class="col-md-8">
                        <input type="text" class="form-control round-form">
                      </div>
                    </div>

                  </div>

                  <div class="col-md-7 col-xs-12 item " id="editFieldBox">
                        <h5 align="center"><b><em> Committee Members </em></b> </h5>
                        <br>
                        
                        <div class='form-group' style='margin-left:5px;margin-right:5px;'>
                            <select class='col-md-3 col-xs-3 item form-control round-form' style='width:45%;'>
                                <option></option>
                            </select>
                            <select class='col-md-3 col-xs-3 item form-control round-form' style='width:45%;'>
                                <option></option>
                            </select>
                            <label class='col-md-1 col-xs-1 control-label'><span id='editRowCommittee' class='fa fa-plus-circle fa-2x'></span></label>
                        </div>
                    

                  </div>


                  <div class="col-md-12 col-xs-12 item text-center">
                      <button type="button" class="submit btn btn-round btn-primary">SUBMIT</button>
                      <button type="button" class="reset btn btn-round btn-default">RESET</button>
                  </div>

                </div>
              </form>
            </div>

            <div class="form-panel">
              <h4 class="mb"><i class="fa fa-angle-right"></i> Add Committee </h4>
              <form class="form-horizontal style-form" method="get" style="display:block;">
              
                <div class="row">
                  <div class="col-md-5 col-xs-12 item ">
                        <h5 align="center"><b><em> Committee Details </em></b> </h5>
                        <br>

                    <div class="form-group">
                      <label class="col-md-4 control-label validate">Name</label>
                      <div class="col-md-8">
                        <input type="text" class="form-control round-form">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-md-4 control-label validate date-before">Formed Date</label>
                      <div class="col-md-8" >
                      <input class="form-control form-control-inline round-form input-medium default-date-picker" size="16" type="text">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-md-4 control-label validate year">Validity</label>
                      <div class="col-md-8">
                        <input type="number" class="form-control round-form">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-md-4 control-label">Description</label>
                      <div class="col-md-8">
                        <input type="text" class="form-control round-form">
                      </div>
                    </div>

                  </div>

                  <div class="col-md-7 col-xs-12 item " id="addFieldBox">
                        <h5 align="center"><b><em> Committee Members </em></b> </h5>
                        <br>
                        
                        <div class='form-group' style='margin-left:5px;margin-right:5px;'>
                            <select class='col-md-3 col-xs-3 item form-control round-form' style='width:45%;'>
                                <option></option>
                            </select>
                            <select class='col-md-3 col-xs-3 item form-control round-form' style='width:45%;'>
                                <option></option>
                            </select>
                            <label class='col-md-1 col-xs-1 control-label'><span id='addRowCommittee' class='fa fa-plus-circle fa-2x'></span></label>
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
    $('#nav-accordion .sub-menu .sub #committee').addClass('active');
      $(document).ready(function(){

        $(".mode").on("click", function(){
          //alert($(this).siblings('form.style-form').tagName);
          $(this).next().toggle('slow');
        });
      });

      $("#addRowCommittee").click(function () {
            $('#addFieldBox').append(`<div class='form-group' id='addField' style='margin-left:5px;margin-right:5px;'>
                            <select class='col-md-3 col-xs-3 item form-control round-form' style='width:45%;'>
                                <option></option>
                            </select>
                            <select class='col-md-3 col-xs-3 item form-control round-form' style='width:45%;'>
                                <option></option>
                            </select>
                            <label class='col-md-1 col-xs-1 control-label'><span id='removeAddCommittee' class='fa fa-minus-circle fa-2x'></span></label>
                        </div>`);

        });

        // remove row
        $(document).on('click', '#removeAddCommitee', function () {
            $(this).closest('#addField').remove();
        });

        $("#editRowCommittee").click(function () {
            $('#editFieldBox').append(`<div class='form-group' id='editField' style='margin-left:5px;margin-right:5px;'>
                            <select class='col-md-3 col-xs-3 item form-control round-form' style='width:45%;'>
                                <option></option>
                            </select>
                            <select class='col-md-3 col-xs-3 item form-control round-form' style='width:45%;'>
                                <option></option>
                            </select>
                            <label class='col-md-1 col-xs-1 control-label'><span id='removeEditCommittee' class='fa fa-minus-circle fa-2x'></span></label>
                        </div>`);

        });

        // remove row
        $(document).on('click', '#removeEditCommittee', function () {
            $(this).closest('#editField').remove();
        });

        // remove row
        $(document).on('click', '#removeAddCommittee', function () {
            $(this).closest('#addField').remove();
        });

        $('.submit').click(function(){
        alert(submittable);
        });



    </script>
      <!--script for this page-->
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>

</body>
</html>
