<!DOCTYPE html>
<html>
<head>
  <title>Skeleton - Thingy - New</title>
</head>
<body>

<h1>New Thingy</h1>

<form action="${rc.contextPath}/thingy" method="post" commandName="thingy">
  <div class="field">
    <label for="thingy_name">Name</label><br />
    <input id="thingy_name" name="name" size="30" type="text" />
  </div>
  <div class="actions">
    <input name="commit" type="submit" value="Create Thingy" />
  </div>
</form>

<a href="${rc.contextPath}/thingy">Back</a>


</body>
</html>
