

    var submittable = false;

    //Coniguring dateTime dropdown box
    $('.table-condensed').find('> tbody > tr > td').css('display','inline-grid');

    //Adding * for Mandatory Fields
    $('.validate').each(function(){

        $(this).append(`<span style=color:red;font-size:15px;">*</span>`);
        $(this).siblings('div').find('.form-control').css("border", "1px solid #ad8dd6");

    });

    //validating Form
    $('.submit').click(function(){

        var flg=true;
        console.log($(this).parents('form'));

        //Resetting Errors
        $(this).parents('form').find('input,select,textarea').each(function(i){

            console.log($(this).css("border"));
            if ($(this).css("border").localeCompare("1px solid rgb(255, 0, 0)")==0)
            {
                console.log($(this));
                if($(this).hasClass('validate'))
                    $(this).css("border","1px solid #ad8dd6");
                else
                    $(this).css("border","1px solid #ccc");
            }
        });

        //Resetting Hidden Values
        $('.form-group[display=none]').children('.form-control').each(function(i){
            console.log($(this));
            $(this).css("border","1px solid #ad8dd6");
            $(this).val = '';
        });


        //Number
        $(this).parents('form').find('input[type=number]').each(function(i){



            if($(this).val().length!=0)
            {
                var mode = $(this).parents('div').siblings('label');
                var str= $.trim($(this).val());
                var min= $(this).attr('min');
                var max= $(this).attr('max');
    
                console.log(mode);
                console.log(str+" "+min+" "+max);

                    //Phone
                    if (mode.hasClass('phone'))
                    {
                        if (str.length!=0 && str.length!=10 && !(str.length==11 && str[0]=='0'))
                        {
                            flg=false;
                            $(this).css("border","1px solid red");
                            console.log("Phone");
                        }
                    }
                    //Pincode
                    else if (mode.hasClass('pincode'))
                    {
                        if (str.length!=6)
                        {
                            flg=false;
                            $(this).css("border","1px solid red");
                            console.log("Pincode");
                        }
                    }

                    //Year
                    else if (mode.hasClass('year'))
                    {
                        if (str.length!=4)
                        {
                            flg=false;
                            $(this).css("border","1px solid red");
                            console.log("Year");
                        }
                    }
                    //General Number
                    else 
                    {
                        if ( parseInt(str)<parseInt(min) || parseInt(str)>parseInt(max) )
                        {
                            //alert($(this).attr('min'));
                            flg=false;
                            $(this).css("border","1px solid red");
                            console.log("Number");
                        }
                    }
            }

            
            
        });

        //Email
        $(this).parents('form').find('input[type=email]').each(function(i){
            if ($(this).val().localeCompare('') != 0 && $(this).val().indexOf('@') == -1 )
            {
                //alert($(this).val());
                flg=false;
                $(this).css("border","1px solid red");
                console.log("email");
            }
        });

        //date-duration for Event
        $(this).parents('form').find('.date-duration').siblings('div').find('> div').each(function(i){
            

            var date1 = $(this).find('> .default-date-picker:eq(0)');
            var date2 = $(this).find('> .default-date-picker:eq(1)');
            console.log(date1.val());
            console.log(date2.val());
            

            if(date1.val().localeCompare('') == 0 )
                date1.css("border","1px solid red");
            else if(date2.val().localeCompare('') == 0 )
                date2.css("border","1px solid red");
            else
            {
                var yr1 = parseInt(date1.val().substring(6,10));
                var mn1 = parseInt(date1.val().substring(0,2));
                var dt1 = parseInt(date1.val().substring(3,5));
    
                var yr2 = parseInt(date2.val().substring(6,10));
                var mn2 = parseInt(date2.val().substring(0,2));
                var dt2 = parseInt(date2.val().substring(3,5));
                
    
                if( yr2<yr1 || (yr2==yr1 && mn2<mn1) || (yr2==yr1 && mn2==mn1 && dt2<dt1))
                {
                    flg=false;
                    date1.css("border","1px solid red");
                    date2.css("border","1px solid red");
                    console.log("date-duration");
                }
            }
        });

        //date-span for Divorce Event
        $(this).parents('form').each(function(i){
    

            if($('.date-span').length)
            {
                var date1 = $("#marriage_date");
                var date2 = $("#divorce_date");
    
                console.log(date1.val());
                console.log(date2.val());
                
                var yr1 = parseInt(date1.val().substring(6,10));
                var mn1 = parseInt(date1.val().substring(0,2));
                var dt1 = parseInt(date1.val().substring(3,5));
    
                var yr2 = parseInt(date2.val().substring(6,10));
                var mn2 = parseInt(date2.val().substring(0,2));
                var dt2 = parseInt(date2.val().substring(3,5));
                
    
                if( yr2<yr1 || (yr2==yr1 && mn2<mn1) || (yr2==yr1 && mn2==mn1 && dt2<dt1))
                {
                    flg=false;
                    date1.css("border","1px solid red");
                    date2.css("border","1px solid red");
                    console.log("date-span");
                }

            }
        });

        //date-before for Event
        $(this).parents('form').find('.date-before').each(function(i){
    

            var date1 = $(this).siblings('div').find('input');
            console.log(date1.val());
            

            if(date1.val().localeCompare('') == 0 )
                date1.css("border","1px solid red");
            else
            {
                var yr1 = parseInt(date1.val().substring(6,10));
                var mn1 = parseInt(date1.val().substring(0,2));
                var dt1 = parseInt(date1.val().substring(3,5));
    
                var yr2 = new Date().getFullYear();
                var mn2 = new Date().getMonth()+1;
                var dt2 = new Date().getDate();
                
    
                if( yr2<yr1 || (yr2==yr1 && mn2<mn1) || (yr2==yr1 && mn2==mn1 && dt2<dt1))
                {
                    flg=false;
                    date1.css("border","1px solid red");
                    console.log("date-before");
                }
            }
        });


        //Mandatory
        $(this).parents('form').find('.validate').siblings('div').children('.form-control').each(function(i){
            //alert($(this).parents('div').siblings('.validate').css('display'));
            //console.log($(this).parents('form').find('.date-duration').siblings('div').children('span').text());
            if($(this).parents('.form-group').css('display').localeCompare('none')==0)
                $(this).val="";
            else
            {
                if ($.trim($(this).val()).localeCompare('')==0)
                {
                    flg=false;
                    $(this).css("border","1px solid red");
                   // console.log("Main");
                }

            }
        });


        if(flg==false)
            alert("Incomplete or Invalid Form Entry");
        else
            submittable = true;
    });


    //sorting
    $('th').click(function(){
        var table = $(this).parents('table').eq(0);
        var rows = table.find('tr:gt(0)').toArray().sort(comparer($(this).index()))
        this.asc = !this.asc
        if (!this.asc)
            rows = rows.reverse();
        for (var i = 0; i < rows.length; i++)
            table.append(rows[i]);
        })
        function comparer(index) {
            return function(a, b) 
            {
                var valA = getCellValue(a, index), valB = getCellValue(b, index)
                return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA.toString().localeCompare(valB)
            }
        }
        function getCellValue(row, index){ 
            return $(row).children('td').eq(index).text() 
        }


    //searching
    $("input.search").on("keyup keydown keypress", function() {
        var value = $.trim($(this).val()).toLowerCase();
        var table = $(this).siblings('table');

        if (value.localeCompare('')!=0)
        {
            table.find('> tbody > tr').each(function(index) {

                //alert($(this).find('td').val());
                if($(this).find('td').val()!=undefined){
                    $row = $(this);
                    var flg=0;
    
                    for(var i=0; i<$row.children('td').length-1; i++){
                        var id = $row.find("td:eq("+i+")").text().toLowerCase();
    
                        if (id.indexOf(value) == 0) {
                            flg=1;
                            $row.show();
                        }
                    }
                    if (flg==0)
                        $row.hide();
                }
            });
        }
        else
        {
            table.find('> tbody > tr').each(function(index) {
                $(this).show();
            });
        }
    });


    //Reset Form
    $('.reset').click(function(){
        if(confirm("Are you sure to reset the form?")){
            console.log($(this).parents('form').trigger("reset"));
        }
    });


    //Reseting File Upload
    $('.file-del').click(function(){
        console.log("Reseting File Upload");

        var box = $(this).parents('.fileuploadbox');
        var element = $(this).parents('.fileupload');

        element.remove();
        box.append(`
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
        
        `);
    });


    //Printing table
    $('.fa-print').click(function(){

        $('table').siblings().hide();
        $('.fa').parents('th,td').hide();
        $('aside,.sidebar-toggle-box,.top-menu').hide();
        window.print();
        $('table').siblings().show();
        $('aside,.sidebar-toggle-box,.top-menu').show();
        $('.fa').parents('th,td').show();
    });

