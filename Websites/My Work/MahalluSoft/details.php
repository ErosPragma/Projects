<!DOCTYPE html>
<html lang="en">

<head>
  <title></title>
  <?php include 'utils/head.php'?>

  <style>
    th,td{
      text-align:center;
    }
    .col-end{
      width:10px;
    }
    .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
        vertical-align: middle;
    }
    #home h3{
      text-transform:capitalize;
    }
  </style>

</head>

<body>
    <?php include 'utils/header.php'?>
    <script>
      var name = "<?php echo $_GET['name'];?>";
      //get data
    </script>
    
    
    <section id="main-content">
      <section class="wrapper">
        <div class="row" style="padding-bottom: 0;min-height:100vh">
          <div class="col-lg-12 main-chart" id="main">

              <!--HEADING-->
              <div class="border-head" id="home">
                <br>
                <h3> <?php echo str_replace("_"," ",$_GET['name']);?> Details </h3>
              </div>

              <!--CONTENT-->
              <div class="row">
                <div class="col-md-12 col-xs-12 item">
                  <!-- TABLE -->
                    <div class="form-panel">
                      <div>
                        <!-- page start-->
                        <div class="content-panel">
                            <input type="text" class="search form-control" placeholder="search" >

                            <table class="display table table-bordered ">
                               <tr>
                                <th>Sl</th>
                                <th>Browser</th>
                                <th>Platform(s)</th>
                                <th style="width:7%;"><span><i class="fa fa-print fa-2x"></i></span></th>
                                </tr>
                              <tr>
                              <td>1</td>
                              <td>2</td>
                              <td class="align-middle">3</td>
                              <td class="col-end"></td>
                              </tr>
                              <tr>
                              <td>110</td>
                              <td>20</td>
                              <td>13</td>
                              <td class="col-end"></td>
                              </tr>
                              <tr>
                              <td>1</td>
                              <td>2</td>
                              <td>3</td>
                              <td class="col-end"></td>
                              </tr>
                             </table>
                          </div>
                          
                      </div>
                    
                    </div>
                </div>
              </div>


          </div>
        </div>
      </section>

    <?php include 'utils/footer.php' ?>
    <script src="lib/script.js"></script>
  <script>
      $('#nav-accordion .mt a').removeClass('active');
      $('#nav-accordion .sub-menu #details').addClass('active');
      $('#nav-accordion .sub-menu .sub #details_'+name).addClass('active');

      $(document).ready(function(){
          $('.col-end').append(`<i class='fa fa-user-circle fa-2x'></i><br><i class='fa fa-pencil-square fa-2x'></i><br><i class='fa fa-times fa-2x'></i>`);
      });
        
  </script>
</body>
</html>
