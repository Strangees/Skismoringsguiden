<?php
echo "<div class=\"demo-card-square mdl-card mdl-shadow--2dp\">";
echo "<div class=\"mdl-card__title mdl-card--expand\"style=\"background: url(";echo "$row[bilde]"; echo ") center no-repeat\">";
echo "</div>";
echo "<div class=\"mdl-card__actions mdl-card--border headertext\">";
echo "$row[navn]";
echo "</div>";
echo "<div class=\"mdl-card__actions mdl-card--border supportertext\">";
echo "$row[beskrivelse]";
echo "</div>";
echo "<div class=\"mdl-card__actions mdl-card--border webtext\">";
echo "<a class=\"mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect\" ";
echo "href=\"";
echo "$row[webside]";
echo "\" target=\"_blank\">";
echo "Gå til nettbutikk";
echo "</a>";
echo "</div> </div>";
 ?>
