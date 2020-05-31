<!DOCTYPE html>
<html lang="en">

<head>

  <title></title>
  <?php include 'utils/head.php'?>

  <style>
    th,td{
      text-align:center;
    }
    .col-end,.sl{
      width:7%;
    }
    .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
        vertical-align: middle;
    }
    input[type=checkbox]{
        margin:0;
        
        
    }
    .checkbox-inline
    {
        margin-left: 10px;
    }
    .pass{
        display:none;
    }
    #notification::-webkit-scrollbar{
        display:none;
    }
    #notification {
        height:521px;
        overflow: overlay;
	}
}
  </style>

</head>

<body>
    <?php include 'utils/header.php'?>
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12 main-chart" id="main">

              <!--HEADING-->
              <div class="border-head" id="home">
                <br>
                <h3> Notification </h3>
              </div>

              <!--CONTENT-->
              <div class="row">
                <div class="col-md-12 col-xs-12 item">
                  <!-- TABLE -->
                    <div class="form-panel" style="background: #d6d9dc;">
                        <!-- page start-->
                        <div class="row mt">
                            <div class="col-sm-12 col-xs-12 upper-box" style="padding-left:50px;">
                                <h5 ><b><em> Filters </em></b> </h5>
                                <label class="checkbox-inline col-sm-2 col-xs-2">
                                    <input type="checkbox"  id="1" checked> Dues
                                    </label>
                                <label class="checkbox-inline col-sm-2 col-xs-2">
                                    <input type="checkbox"  id="2" checked> Login
                                    </label>
                                <label class="checkbox-inline col-sm-2 col-xs-3">
                                    <input type="checkbox" id="3" checked> Requests
                                    </label>
                                <label class="checkbox-inline col-sm-2  col-xs-2">
                                    <input type="checkbox" id="4" checked> Activity
                                    </label>
                                    <br><br>
                            </div>
                        </div>


                        </div>
                            <div class="col-lg-12 ds" id="notification" >
    
                            <!--NOTIFICATION-->
                                    <div class="donut-main" >

                                        <div class="desc dues">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-dues</div>
                                        </div>
                                        <div class="desc login">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-login</div>
                                        </div>
                                        <div class="desc request">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-request</div>
                                        </div>
                                        <div class="desc activity">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-activity</div>
                                        </div>
                                        <div class="desc dues">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-dues</div>
                                        </div>
                                        <div class="desc login">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-login</div>
                                        </div>
                                        <div class="desc request">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-request</div>
                                        </div>
                                        <div class="desc activity">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-activity</div>
                                        </div><div class="desc dues">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-dues</div>
                                        </div>
                                        <div class="desc login">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-login</div>
                                        </div>
                                        <div class="desc request">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-request</div>
                                        </div>
                                        <div class="desc activity">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-activity</div>
                                        </div><div class="desc dues">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-dues</div>
                                        </div>
                                        <div class="desc login">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-login</div>
                                        </div>
                                        <div class="desc request">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-request</div>
                                        </div>
                                        <div class="desc activity">
                                            <div class="thumb"><span class="badge bg-theme"><i class="fa fa-clock-o"></i></span></div>
                                            <div class="thumb"><span class="badge bg-theme-4 date">date</span></div>
                                            <div class="details">content-activity</div>
                                        </div>

                                    </div>
                    
                    </div>
                </div>
            </div>
          </div>
        </div>
      </section>

    <?php include 'utils/footer.php' ?>
  <script>

    $(document).ready(function(){
        $('#1[type="checkbox"]').click(function(){
            $('.dues').toggle();
        });
        $('#2[type="checkbox"]').click(function(){
            $('.login').toggle();
        });
        $('#3[type="checkbox"]').click(function(){
            $('.request').toggle();
        });
        $('#4[type="checkbox"]').click(function(){
            $('.activity').toggle();
        });
    });


        
  </script>
</body>
</html>
