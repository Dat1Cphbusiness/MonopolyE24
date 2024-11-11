## Field data


- **ID**: et tal mellem 1 og 40

- **FieldType:** kan være “Plot”, “Brewery", “ShippingLine", “Chance”, “Prison”, “Visit”, “Parking", “Start” eller “Tax”

- **Label**: navnet på feltet som spilleren ser det
  fx. “Rådhuspladsen”

- **Cost**: prisen ved af en property eller ved betaling af skat
  Felter som ikke er forbundet med en omkostning har 0 som værdi.

- **Income**: det beløb der inkasseres af ejeren når nogen lander på en property.
  Ved start feltet noteres passér start beløbet.

- **Series ID**: et tal der grupperer grunde, redderier eller bryghuse.
- Serierne nummereres fortløbende:

  _Hvidovrevej og Rødovrevej har begge serieID 1_

  _Redderierne har serieID 2_

  _Rådhuspladsen har serieID10_


## Card data

- **message** : besked der beskriver en hændelse

- **income** : det beløb man skal modtage

- **cost**: det beløb der skal betales

- **event**: en hændelse skal kategorieseres som en af følgende typer: reward, rewardFromPlayers, payment, doublePaymentToPlayer, paymentPerProperty, joker, moveTo
- **paymentPerProperty**: Her skal der laves en metode hvor der scannes antal huse og hoteller ejet af en Player, og derefter skal playeren betale et beløb pr. hus og et andet beløb pr. hotel.


## Noter vedrørende "mangler"

## Noter vedrørende cardata.csv
* På linje **8**,**19** og **20** har data'en et format vi ikke håndterer endnu.
