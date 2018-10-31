<?
if (isset ($_POST['messageFF'])) {
  mail ("angelinamarkovych@gmail.com",
        "заповнена контактна форма с ".$_SERVER['HTTP_REFERER'],
        "Імя: ".$_POST['nameFF']."\nEmail: ".$_POST['contactFF']."\nПовідомлення: ".$_POST['messageFF']);
  echo ('<p style="color: green">Ваше повідомлення отримано, дякуємо!</p>');
}
?>
<!-- вариант с кнопкой -->
<input type="button" onclick="history.back();" value="Назад"/>
