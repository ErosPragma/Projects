<script type="text/javascript">
  setInterval(function() {
      var Time = new Date ( );
      var date = Time.getDate();
      var year = Time.getFullYear();
      var day = Time.getDay();
      var month = Time.getMonth();
      var hr = Time.getHours ( );
      var min = Time.getMinutes ( );
      var sec = Time.getSeconds ( );

      var th = parseInt(date);
      if (th%10 == 1) th="st";
      else if (th%10 == 2) th="nd";
      else if (th%10 == 3) th="rd";
      else th="th";

      switch(day)
      {
        case 0: day = "SUN";
                break;
        case 1: day = "MON";
                break;
        case 2: day = "TUE";
                break;
        case 3: day = "WED";
                break;
        case 4: day = "THR";
                break;
        case 5: day = "FRI";
                break;
        case 6: day = "SAT";
                break;
      }
      switch (month)
      {
        case 0: month = "JAN";
                break;
        case 1: month = "FEB";
                break;
        case 2: month = "MAR";
                break;
        case 3: month = "APR";
                break;
        case 4: month = "MAY";
                break;
        case 5: month = "JUN";
                break;
        case 6: month = "JUL";
                break;
        case 7: month = "AUG";
                break;
        case 8: month = "SEP";
                break;
        case 9: month = "OCT";
                break;
        case 10: month = "NOV";
                break;
        case 11: month = "DEC";
                break;
      }

      hr = ( hr > 12 ) ? hr - 12 : hr;
      var when = ( hr < 12 ) ? "AM" : "PM";
      hr = ( hr == 0 ) ? 12 : hr;

      min = ( min < 10 ? "0" : "" ) + min;
      sec = ( sec < 10 ? "0" : "" ) + sec;

      document.getElementById("year").innerHTML = year;
      document.getElementById("month").innerHTML = month;
      document.getElementById("date").innerHTML = date+"<sup>"+th+"</sup> "+day;
      document.getElementById("when").innerHTML = when;
      document.getElementById("hr").innerHTML = hr;
      document.getElementById("min").innerHTML = min;
      document.getElementById("sec").innerHTML = sec;

}, 1000);
</script>

<div class="col-md-12 col-sm-12">
     <div class="home-info">
          <ul class="countdown">
             <li>
                  <span id="hr">  </span>
             </li>
             <li>
                  <span id="min">  </span>
             </li>
             <li>
                  <span id="sec">  </span>
             </li>
             <li >
                  <span id="when"> </span>
             </li>
           </ul>
           <ul class="countdown">
             <li>
               <span id="date">  </span>
             </li>
             <li>
               <span id="month">  </span>
             </li>
             <li>
                  <span id="year">  </span>
             </li>
        </ul>
     </div>
</div>
