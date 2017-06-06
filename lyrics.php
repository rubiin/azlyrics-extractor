<?php
$upbound="<!-- Usage of azlyrics.com content by any third-party lyrics provider is prohibited by our licensing agreement. Sorry about that. -->";
$downbound="<!-- MxM banner -->
";

$arr="";


/*this is static url, you can make this dynamic by getting the artist name and
song name from a textbox and replacing them for example


$url = 'http://www.azlyrics.com/lyrics/'.$artistName.'/'.$songName.'html';

Here variables $artistName and $songName gets there values from form

*/


$url = 'http://www.azlyrics.com/lyrics/alltimelow/foolsholiday.html';



$contents = file_get_contents($url); 
$arr=explode($upbound,$contents);
$contents=$arr[1];

$arr=explode($downbound,$contents);
$contents=$arr[0];



$arr=str_replace("<br>","\n",$contents);
$arr=str_replace("</br>"," ",$arr);
$arr=str_replace("<i>"," ",$arr);
$arr=str_replace("</i>","\n",$arr);
$arr=str_replace("</div>","\ ",$arr);
$contents=trim($arr);


echo $contents;

?>