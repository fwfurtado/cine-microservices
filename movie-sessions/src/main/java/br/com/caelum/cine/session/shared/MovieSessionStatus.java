package br.com.caelum.cine.session.shared;

public enum MovieSessionStatus {
    OPEN {
        @Override
        public MovieSessionStatus start() {
            return STARTED;
        }

        @Override
        public MovieSessionStatus finish() {
            throw new IllegalMovieSessionStatusTransitionException(this, FINISHED);
        }

        @Override
        public MovieSessionStatus cancel() {
            return CANCELED;
        }
    },
    STARTED {
        @Override
        public MovieSessionStatus start() {
            throw new IllegalMovieSessionStatusTransitionException(this, STARTED);
        }

        @Override
        public MovieSessionStatus finish() {
            return FINISHED;
        }

        @Override
        public MovieSessionStatus cancel() {
            return CANCELED;
        }
    },
    FINISHED {
        @Override
        public MovieSessionStatus start() {
            throw new IllegalMovieSessionStatusTransitionException(this, STARTED);
        }

        @Override
        public MovieSessionStatus finish() {
            throw new IllegalMovieSessionStatusTransitionException(this, FINISHED);
        }

        @Override
        public MovieSessionStatus cancel() {
            throw new IllegalMovieSessionStatusTransitionException(this, CANCELED);
        }
    },
    CANCELED {
        @Override
        public MovieSessionStatus start() {
            throw new IllegalMovieSessionStatusTransitionException(this, STARTED);
        }

        @Override
        public MovieSessionStatus finish() {
            throw new IllegalMovieSessionStatusTransitionException(this, FINISHED);
        }

        @Override
        public MovieSessionStatus cancel() {
            throw new IllegalMovieSessionStatusTransitionException(this, CANCELED);
        }
    };

    public abstract MovieSessionStatus start();
    public abstract MovieSessionStatus finish();
    public abstract MovieSessionStatus cancel();

    private static class IllegalMovieSessionStatusTransitionException extends IllegalStateException {

        IllegalMovieSessionStatusTransitionException(MovieSessionStatus from, MovieSessionStatus to) {
            super(String.format("Transition from '%s' to '%s' not allowed.", from, to));
        }
    }
}
