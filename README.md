# NoteApp

NoteApp est une application Android simple permettant de gérer des notes. Elle utilise plusieurs bibliothèques et concepts modernes d'Android pour assurer une expérience utilisateur fluide et réactive. Ce projet est construit en suivant l'architecture MVVM (Model-View-ViewModel) et utilise des composants d'architecture Android tels que Room, ViewModel, LiveData, et RecyclerView.


## Fonctionnalités

- Créer, lire et supprimer des notes.
- Interface utilisateur réactive avec des animations.
- Sauvegarde de l'état des notes même après tout changement de configuration.
- Affichage de la liste des notes avec RecyclerView.

## Technologies Utilisées

- **Android Studio**: IDE pour le développement Android.
- **Kotlin**: Langage de programmation principal pour le développement de l'application.
- **Room**: Pour la gestion de la base de données locale.
- **ViewModel**: Pour gérer les données de l'interface utilisateur de manière réactive.
- **LiveData**: Pour observer les changements de données.
- **SavedStateHandle**: Pour gérer l'état des données lors des changements de configuration.
- **RecyclerView**: Pour afficher la liste des notes de manière efficace.

## Architecture

L'architecture de NoteApp est basée sur le modèle **MVVM**, qui sépare les préoccupations de l'interface utilisateur et des données. Voici un aperçu de l'architecture :

- **Modèle**: Contient la logique métier et la gestion des données (Room).
- **Vue**: Composants d'interface utilisateur (Activités, Fragments).
- **ViewModel**: Gère les données et la logique de présentation. Connecte le modèle à la vue.

  ## Composants Principaux

### Room
Room est utilisé comme couche d'abstraction au-dessus de SQLite pour simplifier les interactions avec la base de données.

- Une entité **Note** est définie pour représenter une note dans la base de données.
- La classe **NoteDao** contient les méthodes d'accès aux données pour effectuer des opérations CRUD (Créer, Lire, Supprimer).
- La base de données **NoteRoomDatabase** est configurée pour gérer l'instance unique de la base de données.

### ViewModel
Le **NotesViewModel** est utilisé pour gérer les données liées à l'interface utilisateur. Il fournit un accès aux données de note et gère la logique de l'application.

### LiveData
**LiveData** est utilisé pour observer les données de note. Lorsqu'une note est ajoutée ou mise à jour, l'interface utilisateur est automatiquement mise à jour sans avoir besoin de code supplémentaire pour gérer les changements.

### SavedStateHandle
Le **SavedStateHandle** est utilisé dans le ViewModel pour sauvegarder et restaurer l'état des notes lors des changements de configuration, comme la rotation de l'écran.

### RecyclerView
**RecyclerView** est utilisé pour afficher la liste des notes. Chaque note est affichée dans un élément de la liste, et les utilisateurs peuvent supprimer les supprimer par un simple balayage.


https://github.com/user-attachments/assets/8b902c94-2a47-47c7-b607-8f809c5edb96


