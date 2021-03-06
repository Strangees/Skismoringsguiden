<!DOCTYPE html>
<html>
<head>
  <script async src="https://www.googletagmanager.com/gtag/js?id=UA-49482907-5"></script>
  <script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'UA-49482907-5');
  </script>
  <!-- Material Design Lite -->
  <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
  <!-- Material Design icon font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <!-- custom css-->
  <link rel="stylesheet" href="../css/nav.css">
  <link rel="stylesheet" href="../css/custom.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
  <div class="background_header">
    <!-- Uses a transparent header that draws on top of the layout's background -->
    <div class="demo-layout-transparent mdl-layout mdl-js-layout">
      <header class="mdl-layout__header mdl-layout__header--transparent">
        <!-- header-row only viewable on big screens-->
        <div class="mdl-layout__header-row">
          <!-- Title -->
          <span class="mdl-layout-title">Title</span>
          <!-- Add spacer, to align navigation to the right -->
          <div class="mdl-layout-spacer"></div>
          <!-- Navigation -->
          <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
            <a class="mdl-navigation__link" href="">Link</a>
          </nav>
        </div>
      </header>
      <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Skismøring</span>
        <nav class="mdl-navigation">
          <a class="mdl-navigation__link" href="../index.html">Voks</a>
          <a class="mdl-navigation__link" href="../index_klister.php">Klister</a>
          <a class="mdl-navigation__link" href="../index_spray.php">Spray</a>
          <a class="mdl-navigation__link" href="../index_glider_base.php">Glidere og baser</a>
          <a class="mdl-navigation__link" href="../index_tilbehør.php">Tilbehør</a>
        </nav>
      </div>
      <main class="mdl-layout__content">
        <div class="buttons_center_card">

          <?php
          include '../php/conn.php';
          $username = USERNAME; //defined in conenction.php
          $password = PASSWORD; //defines in connection.php
          // Create connection
          $conn = new mysqli("localhost", $username, $password, "swc_one");
          //Query
          $sql = "SELECT * FROM `products` WHERE `kategori`=502 ";
          // Check connection
          //test
          if ($conn->connect_error) {
             die("Connection failed: " . $conn->connect_error);
          }
          //resultsvar
           $result = $conn->query($sql);
           if ($result->num_rows > 0) {
   // output data of each row
   while($row = $result->fetch_assoc()) {
     include '../php/fetch.php';
   }
}
else {
   echo "Ingen resultater";
}
$conn->close();
          ?>
          </div>
        </div>
      </main>
    </div>
</body>

</html>
