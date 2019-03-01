<?php 
    $config =  [
                'gallery_name' => 'Group 1 Gallery',
                'unsplash_categories' => ['Nature', 'Sports', 'Forest', 'Computer', 'Science', 'Website', 'Animals', 'Fishing'],
                'local_images' => ['images/Mike_drexler.jpg', 'images/Robson.jpg', 'images/Aaron.jpg', 'images/jon.jpg'],
                'photo_creds' => ['https://unsplash.com/@michaeldrexler?utm_medium=referral&utm_campaign=photographer-credit&utm_content=creditBadge',
                                   'https://unsplash.com/@robsonhmorgan?utm_medium=referral&utm_campaign=photographer-credit&utm_content=creditBadge',
                                   'https://unsplash.com/@aaroncwu?utm_medium=referral&utm_campaign=photographer-credit&utm_content=creditBadge', 
                                   'https://unsplash.com/@jonathan_christian_photography?utm_medium=referral&utm_campaign=photographer-credit&utm_content=creditBadge'    
                                ],
                'names' => ['Mike Drexler', 'Robson Hatsukami Morgan', 'Aaron Wu', 'Jonathan Riley']
                ];

?>

<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="utf-8" />
        <title><?= $config['gallery_name']; ?></title>
        <link rel="stylesheet" href="main.css">
</head>
<body>      
        <h1> <?= $config['gallery_name']; ?> </h1>
        <div id="gallery">
                <?php foreach ($config['unsplash_categories'] as $images): ?>
                        <h2> <?=$images ?> 
                        <img src="https://source.unsplash.com/300x200/?<?=$images?>" alt="<?=$images?>_image" > 
                        </h2>                       
                <?php endforeach ?> 
        </div>
        <div>
                <h1> <?= count($config['local_images']) ?> Large Images </h1>
                <?php for($i = 0 ; $i < count($config['local_images']) ; $i++) { ?>
                        <img id="large-images" src = "<?= $config['local_images'][$i] ?>"> 
                        <h3 class="photographer"> <a href="<?=$config['photo_creds'][$i] ?>"><?= $config['names'][$i] ?> </a></h3>           
                <?php }; ?>
        </div>
</body>
</html>