<section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="index.php" class="logo"><b>MAHALLU<span>SOFT</span></b></a>
      
      <!--logo end-->
      <div class="top-menu">
        
      
        <ul class="nav pull-right top-menu">
          <div class="nav notify-row" id="top_menu">
            <!--  notification start -->
            <ul class="nav top-menu" style="margin-top: 2px">
              <!-- notification dropdown start-->
              
              <li id="header_notification_bar" class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#"   style="margin-right: 0;">
                  <i class="fa fa-search"></i></a>
                <ul class="dropdown-menu extended notification   dropdown-menu-right">
                  <div class="notify-arrow notify-arrow-yellow" style="right: 20px;left: unset;"></div>
                  <li>
                    <p class="yellow">Search By</p>
                  </li>
                  <li><a href="search.php?PID=1"><span class="label label-danger"><i class="fa fa-search"></i></span> House </a></li>
                  <li><a href="search.php?PID=2"><span class="label label-danger"><i class="fa fa-search"></i></span> Member </a></li>
                  <li><a href="search.php?PID=3"><span class="label label-danger"><i class="fa fa-search"></i></span> Blood </a></li>
                  <li><a href="search.php?PID=4"><span class="label label-danger"><i class="fa fa-search"></i></span> Staff </a></li>
                </ul>
              </li>
              <li id="header_notification_bar" class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="index.php#" >
                  <i class="fa fa-bell-o"></i>
                  <span class="badge bg-warning">0</span>
                  </a>
                <ul class="dropdown-menu extended notification   dropdown-menu-right">
                  <div class="notify-arrow notify-arrow-yellow" style="right: 20px;left: unset;"></div>
                  <li>
                    <p class="yellow">Notifications</p>
                  </li>
                  <li>
                    <a href="#">
                      <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                      content
                      </a>
                  </li>
                  <li>
                    <a href="notification.php">See all notifications</a>
                  </li>
                </ul>
              </li>
              <!-- notification dropdown end -->
            </ul>
            <!--  notification end -->
          </div>
          <li>
            <div class="btn-group" style="margin-top: 13px;">
              <button type="button" class="btn btn-theme03"><i class="fa fa-user" aria-hidden="true"></i></button>
              <button type="button" class="btn btn-theme03 dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
                </button>
              <ul class="dropdown-menu dropdown-menu-right" role="menu">
                <li><a href="account_member.php">Add Member Login</a></li>
                <li><a href="settings_password.php">Change Password</a></li>
                <li class="divider"></li>
                <li><a href="settings_website.php">Website Settings</a></li>
                <li><a href="settings_mahallu.php">Mahallu Settings</a></li>
              </ul>
            </div>
          </li>
          <li>&nbsp;</li>
          <li>
            <div class="btn-group" style="margin-top: 13px;">
              <button type="button" class="btn btn-theme03"><a href="login.php" style="color: azure;"><i class="glyphicon glyphicon-log-in"></i></a></button>
            </div>
          </li>
        </ul>
        
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="index.php"><img src="img/logo.png" class="img-circle" width="80"></a></p>
          <h5 class="centered">The Complete Digital Mahallu</h5>
          <li class="mt">
            <a class="active" href="index.php#">
              <i class="fa fa-dashboard"></i>
              <span>Dashboard</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;" id="register">
              <i class="fa fa-desktop"></i>
              <span>Registration</span>
              <i class="fa fa-angle-right" style="float: right; padding-right: 10px;"></i>
              </a>
            <ul class="sub" style="padding-top: 5px;">

              <li><a href="register_house.php" id="house">House Registration</a></li>
              <li><a href="register_member.php" id="member">Member Registration</a></li>
              <li><a href="register_committee.php" id="committee">Committee Registration</a></li>
              <li><a href="register_staff.php" id="staff">Staff Registration</a></li>
              <li><a href="register_institution.php" id="institution">Institution Registration</a></li>
              <li><a href="register_birth.php" id="birth">Birth Registration</a></li>
              <li><a href="register_marriage.php" id="marriage">Marriage Registration</a></li>
              <li><a href="register_divorcee.php" id="divorcee">Divorcee Registration</a></li>
              <li><a href="register_death.php" id="death">Death Registration</a></li>
              <li><a href="register_qabar.php" id="qabar">Qabar Registration</a></li>
              <li><a href="register_minutes.php" id="minutes">Minutes Registration</a></li>
              <li><a href="register_noc_issue.php" id="noc_issue">NOC Issue Registration</a></li>
              <li><a href="register_noc_receive.php" id="noc_receive">NOC Receive Registration</a></li>
              
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;" id="details">
              <i class="fa fa-desktop"></i>
              <span>Details</span>
              <i class="fa fa-angle-right" style="float: right; padding-right: 10px;"></i>
              </a>
            <ul class="sub" style="padding-top: 5px;">

              <li><a href="details.php?name=house" id="details_house">House Details</a></li>
              <li><a href="details.php?name=member" id="details_member">Member Details</a></li>
              <li><a href="details.php?name=committee" id="details_committee">Committee Details</a></li>
              <li><a href="details.php?name=staff" id="details_staff">Staff Details</a></li>
              <li><a href="details.php?name=institution" id="details_institution">Institution Details</a></li>
              <li><a href="details.php?name=birth" id="details_birth">Birth Details</a></li>
              <li><a href="details.php?name=marriage" id="details_marriage">Marriage Details</a></li>
              <li><a href="details.php?name=divorcee" id="details_divorcee">Divorcee Details</a></li>
              <li><a href="details.php?name=death" id="details_death">Death Details</a></li>
              <li><a href="details.php?name=qabar" id="details_qabar">Qabar Details</a></li>
              <li><a href="details.php?name=minutes" id="details_minutes">Minutes Details</a></li>
              <li><a href="details.php?name=noc_issue" id="details_noc_issue">NOC Issue Details</a></li>
              <li><a href="details.php?name=noc_receive" id="details_noc_receive">NOC Receive Details</a></li>
              
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;" id="account">
              <i class="fa fa-desktop"></i>
              <span>Accounts</span>
              <i class="fa fa-angle-right" style="float: right; padding-right: 10px;"></i>
              </a>
            <ul class="sub" style="padding-top: 5px;">

              <li><a href="account_add.php" id="add">Add Account</a></li>
              <li><a href="account_category.php" id="category">Add Transaction Category</a></li>
              <li  class="sub-menu">
                <a href="javascript:;" id="transaction">Add Transaction<i class="fa fa-angle-right" style="float: right; padding-right: 10px; padding-top: 7px;"></i></a>
                <ul class="sub"  style="padding-top: 5px;">
                  <li><a href="account_transaction.php?mode=2" id="receipt">Receipt</a></li>
                  <li><a href="account_transaction.php?mode=1" id="payment">Payment</a></li>
                </ul>
              </li>
              <li><a href="account_dues.php" id="dues">Transaction Dues</a></li>
              <li><a href="account_statement.php" id="statement">Accounts Statement</a></li>
              
            </ul>
            
            
          </li>
          <li class="sub-menu">
            <a href="javascript:;" id="subscribe">
              <i class="fa fa-desktop"></i>
              <span>Subscription</span>
              <i class="fa fa-angle-right" style="float: right; padding-right: 10px;"></i>
              </a>
            <ul class="sub" style="padding-top: 5px;">

            <li><a href="subscription_create.php" id="s_create">Create Subscription</a></li>
            <li><a href="subscription_add.php" id="s_add">Add Subscription</a></li>
            <li><a href="subscription_report.php" id="s_report">Subscription Report</a></li>
            <li><a href="subscription_pay.php" id="s_pay">Subscription Payments</a></li>
              
            </ul>
          </li>
          <li>
            <a href="request.php" id="request">
              <i class="fa fa-check-square-o"></i>
              <span>Request</span>
              </a>
          </li>
          <li>
            <a href="activity.php" id="activity">
              <i class="fa fa-caret-square-o-right"></i>
              <span>Add Activity</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;" id="settings">
              <i class="fa fa-desktop"></i>
              <span>Settings</span>
              <i class="fa fa-angle-right" style="float: right; padding-right: 10px;"></i>
              </a>
            <ul class="sub" style="padding-top: 5px;" >

              <li><a href="settings_website.php" id="website">Website Settings</a></li>
              <li><a href="settings_mahallu.php" id="mahallu">Mahallu Settings</a></li>
            </ul>
          </li>
          <li  class="sub-menu"></li>

        </ul>
        <script>

          function onScroll(event){
            var scrollPos = $(document).scrollTop();
            $('li>a').each(function () {
                var currLink = $(this);
                var refElement = $(currLink.attr("href"));
                if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
                    $('li>a.active').removeClass("active");
                    currLink.addClass("active");
                }
                else{
                    currLink.removeClass("active");
                }
            });
            }
          
        </script>
        <!-- sidebar menu end-->
      </div>
    </aside>